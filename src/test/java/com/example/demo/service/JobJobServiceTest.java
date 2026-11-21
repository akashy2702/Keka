package com.example.demo.service;

import com.example.demo.dto.CreateItemRequest;
import com.example.demo.exception.ItemNotFoundException;
import com.example.demo.model.JobItem;
import com.example.demo.repository.JobRepository;
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
class JobJobServiceTest {
    @Mock
    private JobRepository jobRepository;

    @InjectMocks
    private JobService jobService;

//    @Test
//    void createsItem() {
//        when(jobRepository.save(any(JobItem.class))).thenAnswer(invocation -> invocation.getArgument(0));
//
//        JobItem result = jobService.create(new CreateItemRequest("Sample Item", "Test item"));
//
//        assertNotNull(result.id());
//        assertEquals("Sample Item", result.name());
//        assertNotNull(result.createdAt());
//        verify(jobRepository).save(result);
//    }
//
//    @Test
//    void throwsWhenItemDoesNotExist() {
//        when(jobRepository.findById("missing")).thenReturn(Optional.empty());
//
//        assertThrows(ItemNotFoundException.class, () -> jobService.getById("missing"));
//    }
}
