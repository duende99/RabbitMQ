package com.deamon.rabbitproduct.direct;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.error}", autoDelete = "true"),
                exchange = @Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.DIRECT),
                key = "${mq.config.queue.error.routing.key}"
        )
)
public class ErrorReceiver {

    //todo 这里注释了，用的时候解开
//    @RabbitHandler
    public void process(String msg) {
        System.out.println("error========" + "receiver:" + msg);

    }
}
