package com.travel.consumer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Service
public class MessageListener {

    private final RabbitTemplate rabbitTemplate;
    private final Queue responseQueue;

    @Autowired
    public MessageListener(RabbitTemplate rabbitTemplate, Queue responseQueue) {
        this.rabbitTemplate = rabbitTemplate;
        this.responseQueue = responseQueue;
    }

    @RabbitListener(queues = "${travel.request.queue.name}")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);

        // Process the message (could be any logic)
        String processedMessage = "Approved: " + message;

        // Send the processed message to the response queue (instead of the same queue)
        rabbitTemplate.convertAndSend(responseQueue.getName(), processedMessage);
        System.out.println("Sent processed message: " + processedMessage);
    }
}
