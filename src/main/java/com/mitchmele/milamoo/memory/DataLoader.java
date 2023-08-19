package com.mitchmele.milamoo.memory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationListener<ApplicationReadyEvent> {

    private final MemoryRepository repository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Memory mem1 = new Memory("", "test one", new Date(50000));
        Memory mem2 = new Memory("", "test two", new Date(80000));
        Memory mem3 = new Memory("", "test three", new Date(90000));


        log.info("SAVING START");
        repository.saveAll(List.of(mem1, mem2, mem3));
        log.info("SAVING END");
    }
}
