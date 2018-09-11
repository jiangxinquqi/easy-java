package com.xiao.jms;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;

/**
 * @desc: 功能描述：（）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/9/4 22:33
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ActiveMQApplicationTest {

    @Autowired
    private Producer producer;

    @Test
    public void contextLoads() throws InterruptedException {
        Destination destination = new ActiveMQQueue("mytest.queue");

        for (int i = 0; i < 100; i++) {
            String msg = "name:" + i + ",day:" + System.currentTimeMillis();
            System.out.println("=========producer发送的报文：" + msg);
            producer.sendMessage(destination, msg);
            Thread.sleep(1000);
            System.out.println("=========producer发送的报文：" + msg + "=========完毕");
        }
    }
}
