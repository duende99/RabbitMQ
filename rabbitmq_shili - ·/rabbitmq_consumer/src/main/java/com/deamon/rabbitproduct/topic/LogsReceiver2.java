package com.deamon.rabbitproduct.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.topic.log}", autoDelete = "true"),
                exchange = @Exchange(value = "${mq.config.exchange.topic}",type = ExchangeTypes.TOPIC),
                key = "*.log.*"
        )
)
public class LogsReceiver2 {


    @RabbitHandler
    public void process(String msg) {

        System.out.println("======logs========" + msg);

    }
}
