package com.mitchmele.milamoo.memory.controller;

import com.mitchmele.milamoo.memory.MemoriesResponse;
import com.mitchmele.milamoo.memory.Memory;
import com.mitchmele.milamoo.memory.MemoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MemoriesController {

    private final MemoryRepository memoryRepository;

    @GetMapping("/memories")
    public ResponseEntity<MemoriesResponse> getMemories() {
        List<Memory> memories = memoryRepository.findAll();
        return ResponseEntity.ok(MemoriesResponse.builder().memories(memories).status("SUCCESS").build());
    }

    @GetMapping("/memories/{id}")
    public ResponseEntity<Memory> getMemories(@PathVariable final long id) {
        Optional<Memory> memory = memoryRepository.findById(id);
        return memory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.internalServerError().build());
    }
}
