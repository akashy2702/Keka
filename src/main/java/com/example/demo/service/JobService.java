package com.example.demo.service;

import com.example.demo.dto.CreateItemRequest;
import com.example.demo.exception.ItemNotFoundException;
import com.example.demo.model.JobItem;
import com.example.demo.model.JobPriority;
import com.example.demo.repository.JobRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public JobItem create(CreateItemRequest request) {
        JobItem jobItem = new JobItem(UUID.randomUUID().toString(), JobPriority.from(request.priority()), request.name(), request.description(), request.scheduledAt());
        JobItem saved = jobRepository.save(jobItem);
        log.info("Created job with id {}", saved.id());
        return saved;
    }

    public List<String> getOrder() {
        return jobRepository.getOrder();
    }

//    public JobItem getById(String id) {
//        return jobRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
//    }
//
//    public List<JobItem> getAll() {
//        return jobRepository.findAll();
//    }
//
//    public void delete(String id) {
//        getById(id);
//        jobRepository.deleteById(id);
//        log.info("Deleted item with id {}", id);
//    }
//
//    public void deleteAll() {
//        jobRepository.deleteAll();
//        log.info("Deleted all items ");
//    }
}
