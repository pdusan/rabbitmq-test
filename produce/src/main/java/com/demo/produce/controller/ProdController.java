package com.demo.produce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.produce.domain.Item;
import com.demo.produce.service.ProdService;

@RestController
public class ProdController {

    private ProdService producerService;
    private static final Logger logger = LoggerFactory.getLogger(ProdController.class);

    public ProdController(ProdService producerService) {
        this.producerService = producerService;
    }

    @Value("${app.message}")
    private String response;

    @PostMapping("/produce")
    public ResponseEntity<String> sendMessage(@RequestBody Item item) {
        producerService.sendItem(item);
        logger.info("item sent: " + item);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/string")
    public ResponseEntity<String> sendString(@RequestBody String msg) {
        producerService.sendString(msg);
        logger.info("String sent: " + msg);
        return ResponseEntity.ok(response);
    }
}