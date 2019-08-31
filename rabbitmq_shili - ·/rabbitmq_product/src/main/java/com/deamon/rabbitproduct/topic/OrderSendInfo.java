package com.deamon.rabbitproduct.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderSendInfo {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${mq.config.exchange.topic}")
    private String exchange;

    public void sendInfo(String msg) {
        amqpTemplate.convertAndSend(exchange, "order.log.info", "order---" + msg);
        amqpTemplate.convertAndSend(exchange, "order.log.debug", "order---" + msg);
        amqpTemplate.convertAndSend(exchange, "order.log.warn", "order---" + msg);
        amqpTemplate.convertAndSend(exchange, "order.log.error", "order---" + msg);
    }


    public void sendError() {
        amqpTemplate.convertAndSend(exchange, "", "hello, rabbitmq error!");
    }
}
