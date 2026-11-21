package com.example.demo.model;

import java.time.LocalDateTime;

public record Item(String id, String name, String description, LocalDateTime createdAt) {
}
