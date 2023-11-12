package com.mitchmele.milamoo.memory.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mitchmele.milamoo.memory.MemoriesResponse;
import com.mitchmele.milamoo.memory.Memory;
import com.mitchmele.milamoo.memory.MemoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Incubating;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MemoriesControllerTest {

    @Mock
    private MemoryRepository repository;

    @InjectMocks
    private MemoriesController controller;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getAllMemories() throws Exception {

        Date mem1Date = mock(Date.class);
        Memory mem1 = new Memory("src", "cool pic", mem1Date);
        Memory mem2 = new Memory("src2", "mountain pic", mem1Date);

        List<Memory> expected = List.of(mem1, mem2);
        when(repository.findAll()).thenReturn(expected);

        mockMvc.perform(get("/api/v1/memories"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(objectMapper.writeValueAsString(MemoriesResponse.builder().memories(expected).build())));
    }
}