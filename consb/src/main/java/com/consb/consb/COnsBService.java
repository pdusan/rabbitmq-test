package com.consb.consb;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class COnsBService {

    @RabbitListener(queues = "item_queue_2")
    public void listen(Item item) {
        log.info("message received: " + item);
    }

}
