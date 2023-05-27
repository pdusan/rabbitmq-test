package com.demo.consume.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.consume.domain.Item;
import com.demo.consume.repo.ItemRepo;

@Service
public class ConsumeService {

    private final ItemRepo userRepository;
    private static final Logger logger = LoggerFactory.getLogger(ConsumeService.class);

    @Autowired
    public ConsumeService(ItemRepo userRepository) {
        this.userRepository = userRepository;
    }

    @RabbitListener(queues = "item.queue")
    public void receivedMessage(Item item) {
        Item save = userRepository.save(item);
        logger.info("persisted " + save);
        logger.info("User Details Received is.. " + item);
    }

}