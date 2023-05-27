package com.demo.produce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public ProdController(ProdService producerService) {
        this.producerService = producerService;
    }

    @Value("${app.message}")
    private String response;

    @PostMapping("/produce")
    public ResponseEntity<String> sendMessage(@RequestBody Item item) {
        producerService.sendMessage(item);
        logger.info("item sent: " + item);
        return ResponseEntity.ok(response);
    }
}