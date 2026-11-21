package com.example.demo.dto;

import com.example.demo.model.JobItem;

import java.time.LocalDateTime;

public record JobItemResponse(String id, String priority, String name, String description, Long scheduleAt) {
    public static JobItemResponse from(JobItem jobItem) {
        return new JobItemResponse(jobItem.id(), jobItem.priority().name(), jobItem.name(), jobItem.description(), jobItem.scheduleAt());
    }
}
