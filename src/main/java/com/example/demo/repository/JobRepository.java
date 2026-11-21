package com.example.demo.repository;

import com.example.demo.model.JobItem;

import java.util.List;
import java.util.Optional;

public interface JobRepository {
    JobItem save(JobItem jobItem);

    List<String> getOrder();
//    Optional<JobItem> findById(String id);
//
//    List<JobItem> findAll();
//
//    void deleteById(String id);
//
//    void deleteAll();
}
