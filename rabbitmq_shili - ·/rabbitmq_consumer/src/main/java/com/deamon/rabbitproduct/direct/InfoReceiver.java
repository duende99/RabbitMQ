package com.deamon.rabbitproduct.direct;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;


/***
 * autoDelete: true 代表当消费连接应用断开时，会删除队列，否则，队列会持久化
 */
@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.info}", autoDelete = "false"),
                exchange = @Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.DIRECT),
                key = "${mq.config.queue.info.routing.key}"
        )
)
public class InfoReceiver {


//    @RabbitHandler
    public void process(String msg) {
        System.out.println("info========" + "receiver:" + msg);

    }
}
