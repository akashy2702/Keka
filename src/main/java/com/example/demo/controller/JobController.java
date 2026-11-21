package com.example.demo.controller;

import com.example.demo.dto.CreateItemRequest;
import com.example.demo.dto.ExecutionOrderResponse;
import com.example.demo.dto.JobItemResponse;
import com.example.demo.service.JobService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public ResponseEntity<JobItemResponse> submit(@Valid @RequestBody CreateItemRequest request) {
        log.info("Received request to submit a job");
        JobItemResponse response = JobItemResponse.from(jobService.create(request));
        return ResponseEntity.created(URI.create("/api/v1/jobs/" + response.id())).body(response);
    }

    @GetMapping("/executionOrder")
    public ResponseEntity<ExecutionOrderResponse> getById() {
        return ResponseEntity.ok(
            new ExecutionOrderResponse(jobService.getOrder())
        );
    }

//    @GetMapping
//    public List<JobItemResponse> getAll() {
//        return jobService.getAll().stream().map(JobItemResponse::from).toList();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable String id) {
//        jobService.delete(id);
//        return ResponseEntity.noContent().build();
//    }

//    @DeleteMapping
//    public ResponseEntity<Void> deleteAll() {
//        itemService.deleteAll();
//        return ResponseEntity.noContent().build();
//    }
}
