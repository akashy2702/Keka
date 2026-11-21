package com.example.demo.service;

import com.example.demo.dto.CreateItemRequest;
import com.example.demo.exception.ItemNotFoundException;
import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item create(CreateItemRequest request) {
        Item item = new Item(UUID.randomUUID().toString(), request.name(), request.description(), LocalDateTime.now());
        Item saved = itemRepository.save(item);
        log.info("Created item with id {}", saved.id());
        return saved;
    }

    public Item getById(String id) {
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    public void delete(String id) {
        getById(id);
        itemRepository.deleteById(id);
        log.info("Deleted item with id {}", id);
    }

    public void deleteAll() {
        itemRepository.deleteAll();
        log.info("Deleted all items ");
    }
}
