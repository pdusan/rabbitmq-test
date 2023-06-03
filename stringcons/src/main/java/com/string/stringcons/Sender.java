package com.string.stringcons;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Sender {

    @RabbitListener(queues = "string_queue")
    public void get(String msg) {
        log.info("RECEIVED STRING: " + msg);
    }
}
