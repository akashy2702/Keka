package com.example.demo.service;

import com.example.demo.dto.CreateItemRequest;
import com.example.demo.exception.ItemNotFoundException;
import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {
    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @Test
    void createsItem() {
        when(itemRepository.save(any(Item.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Item result = itemService.create(new CreateItemRequest("Sample Item", "Test item"));

        assertNotNull(result.id());
        assertEquals("Sample Item", result.name());
        assertNotNull(result.createdAt());
        verify(itemRepository).save(result);
    }

    @Test
    void throwsWhenItemDoesNotExist() {
        when(itemRepository.findById("missing")).thenReturn(Optional.empty());

        assertThrows(ItemNotFoundException.class, () -> itemService.getById("missing"));
    }
}
