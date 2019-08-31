package com.deamon.rabbitproduct.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductSendInfo {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${mq.config.exchange.topic}")
    private String exchange;

    public void sendInfo(String msg) {
        amqpTemplate.convertAndSend(exchange, "product.log.info", "product---" + msg);
        amqpTemplate.convertAndSend(exchange, "product.log.debug", "product---" + msg);
        amqpTemplate.convertAndSend(exchange, "product.log.warn", "product---" + msg);
        amqpTemplate.convertAndSend(exchange, "product.log.error", "product---" + msg);
    }


    public void sendError() {
        amqpTemplate.convertAndSend(exchange, "", "hello, rabbitmq error!");
    }
}
