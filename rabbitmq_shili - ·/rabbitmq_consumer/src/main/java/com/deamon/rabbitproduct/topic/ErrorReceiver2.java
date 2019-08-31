package com.deamon.rabbitproduct.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.topic.error}", autoDelete = "true"),
                exchange = @Exchange(value = "${mq.config.exchange.topic}",type = ExchangeTypes.TOPIC),
                key = "*.log.error"
        )
)
public class ErrorReceiver2 {

//    @RabbitHandler
    public void process(String msg) {

        System.out.println("======error========" + msg);

    }
}
