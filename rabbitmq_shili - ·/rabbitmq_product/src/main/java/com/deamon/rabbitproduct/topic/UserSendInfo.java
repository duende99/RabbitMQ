package com.deamon.rabbitproduct.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserSendInfo {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${mq.config.exchange.topic}")
    private String exchange;

    public void sendInfo(String msg) {
        amqpTemplate.convertAndSend(exchange, "user.log.info", "user---" + msg);
        amqpTemplate.convertAndSend(exchange, "user.log.debug", "user---" + msg);
        amqpTemplate.convertAndSend(exchange, "user.log.warn", "user---" + msg);
        amqpTemplate.convertAndSend(exchange, "user.log.error", "user---" + msg);
    }


    public void sendError() {
        amqpTemplate.convertAndSend(exchange, "", "hello, rabbitmq error!");
    }
}
