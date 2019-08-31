package com.deamon.rabbitproduct.fanout;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;


/***
 * 这里fanout模式没有路由模式
 */
@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.push}", autoDelete = "true"),
                exchange = @Exchange(value = "${mq.config.exchange.fanout}",type = ExchangeTypes.FANOUT)
        )
)
public class PushReceiver {

    @RabbitHandler
    public void process(String msg) {

        System.out.println("======push========" + msg);

    }
}
