package com.deamon.rabbitproduct.ack;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AckSendInfo {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${mq.config.exchange}")
    private String exchange;

    @Value("${mq.config.queue.info.routing.key}")
    private String routingKey;

    @Value("${mq.config.queue.error.routing.key}")
    private String routingKey2;

    public void sendInfo(String msg) {

        amqpTemplate.convertAndSend(exchange, routingKey, msg);

    }


    public void sendError() {

        amqpTemplate.convertAndSend(exchange, routingKey2, "hello, rabbitmq error!");

    }
}
