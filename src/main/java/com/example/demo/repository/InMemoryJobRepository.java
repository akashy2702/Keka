package com.example.demo.repository;

import com.example.demo.model.Item;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryItemRepository implements ItemRepository {
    private final ConcurrentHashMap<String, Item> items = new ConcurrentHashMap<>();

    @Override
    public Item save(Item item) {
        items.put(item.id(), item);
        return item;
    }

    @Override
    public Optional<Item> findById(String id) {
        return Optional.ofNullable(items.get(id));
    }

    @Override
    public List<Item> findAll() {
        return List.copyOf(items.values());
    }

    @Override
    public void deleteById(String id) {
        items.remove(id);
    }

    @Override
    public void deleteAll() {
        items.clear();
    }
}
