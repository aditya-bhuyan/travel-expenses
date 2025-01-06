package com.travel.consumer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    @Autowired
    public MessageListener(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    // This method will be triggered when a message is received from the queue
    @RabbitListener(queues = "${travel.queue.name}")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);

        // Process the message (this could be any logic)
        String processedMessage = "Approved: " + message;

        // Send the processed message to the same or another queue
        rabbitTemplate.convertAndSend(queue.getName(), processedMessage);
        System.out.println("Sent message: " + processedMessage);
    }
}
