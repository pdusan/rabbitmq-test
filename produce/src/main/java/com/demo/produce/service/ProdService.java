package com.demo.produce.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.demo.produce.domain.Item;

@Service
public class ProdService {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public ProdService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;

    public void sendMessage(Item item) {
        rabbitTemplate.convertAndSend(exchange, routingkey, item);
    }

}