package com.deamon.rabbitproduct.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FanoutSendInfo {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${mq.config.exchange.fanout}")
    private String exchange;

    public void sendInfo(String msg) {
        amqpTemplate.convertAndSend(exchange,"", msg);
    }


    public void sendError() {
        amqpTemplate.convertAndSend(exchange, "", "hello, rabbitmq error!");
    }
}
