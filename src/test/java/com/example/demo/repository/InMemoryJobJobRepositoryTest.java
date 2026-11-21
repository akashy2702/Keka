package com.example.demo.repository;

import com.example.demo.model.Item;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InMemoryItemRepositoryTest {
    private final InMemoryItemRepository repository = new InMemoryItemRepository();

    @Test
    void savesAndRetrievesItems() {
        Item item = new Item("id-1", "Item", "Description", LocalDateTime.now());

        repository.save(item);

        assertEquals(item, repository.findById("id-1").orElseThrow());
        assertEquals(1, repository.findAll().size());
        repository.deleteById("id-1");
        assertTrue(repository.findById("id-1").isEmpty());
    }
}
