package com.travel.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue requestQueue() {
        return new Queue("travel-expenses-request-queue", true); // for the producer to send messages
    }

    @Bean
    public Queue responseQueue() {
        return new Queue("travel-expenses-response-queue", true); // for the consumer to send processed messages
    }
}
