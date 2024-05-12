package com.fastcamp.tddstarter.controller;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public ResponseEntity<String> test() throws InterruptedException {
        log.info("nGrinder Testing : {}, {}", this.getClass().toString(), LocalDateTime.now());
        return new ResponseEntity<>(
            "nGrinder Testing",
            HttpStatus.OK
        );
    }
}
