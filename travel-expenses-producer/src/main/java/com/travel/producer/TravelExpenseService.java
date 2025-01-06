package com.travel.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelExpenseService {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    @Autowired
    public TravelExpenseService(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    public void submitExpenseRequest(String request) {
        rabbitTemplate.convertAndSend(queue.getName(), request);
        System.out.println("Sent: " + request);
    }
}

