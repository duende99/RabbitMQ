package com.deamon.rabbitproduct.fanout;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.sms}", autoDelete = "true"),
                exchange = @Exchange(value = "${mq.config.exchange.fanout}",type = ExchangeTypes.FANOUT)
        )
)
public class SmsReceiver {

    @RabbitHandler
    public void process(String msg) {

        System.out.println("======sms========" + msg);

    }
}
