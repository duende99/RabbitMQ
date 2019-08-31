package com.deamon.rabbitproduct.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.topic.info}", autoDelete = "true"),
                exchange = @Exchange(value = "${mq.config.exchange.topic}",type = ExchangeTypes.TOPIC),
                key = "*.log.info"
        )
)
public class InfoReceiver2 {

//    @RabbitHandler
    public void process(String msg) {

        System.out.println("======info========" + msg);

    }
}
