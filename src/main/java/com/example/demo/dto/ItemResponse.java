package com.example.demo.dto;

import com.example.demo.model.Item;

import java.time.LocalDateTime;

public record ItemResponse(String id, String name, String description, LocalDateTime createdAt) {
    public static ItemResponse from(Item item) {
        return new ItemResponse(item.id(), item.name(), item.description(), item.createdAt());
    }
}
