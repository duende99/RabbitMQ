package com.deamon.rabbitproduct;

import com.deamon.rabbitproduct.ack.AckSendInfo;
import com.deamon.rabbitproduct.direct.SendInfo;
import com.deamon.rabbitproduct.fanout.FanoutSendInfo;
import com.deamon.rabbitproduct.topic.OrderSendInfo;
import com.deamon.rabbitproduct.topic.ProductSendInfo;
import com.deamon.rabbitproduct.topic.UserSendInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitProductApplicationTests {

    @Autowired
    private UserSendInfo userSendInfo;
    @Autowired
    private ProductSendInfo productSendInfo;
    @Autowired
    private OrderSendInfo orderSendInfo;

    @Autowired
    private FanoutSendInfo fanoutSendInfo;

    @Autowired
    private SendInfo sendInfo;

    @Autowired
    private AckSendInfo ackSendInfo;

    @Test
    public void sendInfoAck() {
        ackSendInfo.sendInfo("hello rabbitmq");
    }


    @Test
    public void sendInfoDirect() {
        int flag = 0;
        while (true) {
            try {
                flag ++;
                Thread.sleep(2000);
                sendInfo.sendInfo("hello rabbitmq  " + flag);
                System.out.println("======" + flag);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void sendInfoFanout() {
        fanoutSendInfo.sendInfo("hello rabbitmq fanout");
    }

    @Test
    public void sendInfoTopic() {
        userSendInfo.sendInfo("userSend======");
        productSendInfo.sendInfo("productSend======");
        orderSendInfo.sendInfo("orderSend======");
    }


}
