package com.example.demo.controller;

import com.example.demo.dto.CreateItemRequest;
import com.example.demo.dto.ItemResponse;
import com.example.demo.service.ItemService;
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
@RequestMapping("/api/v1/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemResponse> create(@Valid @RequestBody CreateItemRequest request) {
        log.info("Received request to create an item");
        ItemResponse response = ItemResponse.from(itemService.create(request));
        return ResponseEntity.created(URI.create("/api/v1/items/" + response.id())).body(response);
    }

    @GetMapping("/{id}")
    public ItemResponse getById(@PathVariable String id) {
        return ItemResponse.from(itemService.getById(id));
    }

    @GetMapping
    public List<ItemResponse> getAll() {
        return itemService.getAll().stream().map(ItemResponse::from).toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        itemService.delete(id);
        return ResponseEntity.noContent().build();
    }

//    @DeleteMapping
//    public ResponseEntity<Void> deleteAll() {
//        itemService.deleteAll();
//        return ResponseEntity.noContent().build();
//    }
}
