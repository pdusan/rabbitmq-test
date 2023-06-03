package com.demo.produce.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.demo.produce.domain.Item;

@Service
public class ProdService {

    private RabbitTemplate rabbitTemplate;

    public ProdService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendItem(Item item) {
        rabbitTemplate.convertAndSend("test_exchange", "item.test", item);
    }

    public void sendString(String item) {
        rabbitTemplate.convertAndSend("test_exchange", "string.test", item);
    }

}