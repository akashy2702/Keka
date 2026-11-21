package com.example.demo.model;

public record JobItem(String id, JobPriority priority, String name, String description, Long scheduleAt) {
}
