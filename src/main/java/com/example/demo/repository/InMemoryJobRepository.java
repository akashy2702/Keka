package com.example.demo.repository;

import com.example.demo.model.JobItem;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryJobRepository implements JobRepository {
    private final PriorityQueue<JobItem> jobs = new PriorityQueue<>(
        (job1, job2) -> {
            if (job1.priority() == job2.priority()) {
                return Long.compare(job1.scheduleAt(), job2.scheduleAt());
            } else {
                return Integer.compare(job1.priority().getValue(), job2.priority().getValue());
            }
        }
    );

    @Override
    public JobItem save(JobItem jobItem) {
        jobs.add(jobItem);
        return jobItem;
    }

    @Override
    public List<String> getOrder() {
        List<String> executionOrder = new ArrayList<>();
        while(!jobs.isEmpty()) {
            JobItem job = jobs.poll();
            executionOrder.add(job.name());
        }
        return executionOrder;
    }

//    @Override
//    public Optional<JobItem> findById(String id) {
//        return Optional.ofNullable(jobs.get(id));
//    }

//    @Override
//    public List<JobItem> findAll() {
//        return List.copyOf(jobs.values());
//    }

//    @Override
//    public void deleteById(String id) {
//        jobs.remove(id);
//    }

//    @Override
//    public void deleteAll() {
//        jobs.clear();
//    }
}
