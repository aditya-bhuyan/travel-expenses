package com.travel.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelExpenseService {

    private final RabbitTemplate rabbitTemplate;
    private final Queue requestQueue;

    @Autowired
    public TravelExpenseService(RabbitTemplate rabbitTemplate, Queue requestQueue) {
        this.rabbitTemplate = rabbitTemplate;
        this.requestQueue = requestQueue;
    }

    public void submitExpenseRequest(String request) {
        rabbitTemplate.convertAndSend(requestQueue.getName(), request);
        System.out.println("Sent expense request: " + request);
    }
}
