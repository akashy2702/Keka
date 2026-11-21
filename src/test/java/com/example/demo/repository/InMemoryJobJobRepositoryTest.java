package com.example.demo.repository;

import com.example.demo.model.JobItem;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InMemoryJobJobRepositoryTest {
    private final InMemoryJobRepository repository = new InMemoryJobRepository();

//    @Test
//    void savesAndRetrievesItems() {
//        JobItem jobItem = new JobItem("id-1", "Item", "Description", LocalDateTime.now());
//
//        repository.save(jobItem);
//
//        assertEquals(jobItem, repository.findById("id-1").orElseThrow());
//        assertEquals(1, repository.findAll().size());
//        repository.deleteById("id-1");
//        assertTrue(repository.findById("id-1").isEmpty());
//    }
}
