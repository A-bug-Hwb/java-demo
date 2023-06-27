package com.demo.mq.RedisMq;

import com.demo.mq.RedisMq.AnnouncementMessage;
import com.demo.mq.RedisMq.service.MessageProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: crush
 * @Date: 2021-08-06 17:11
 * version 1.0
 */
@SpringBootTest
public class MessageQueueTest {

    @Autowired
    private MessageProducerService producer;

    /**
     * 这个测时 的先启动主启动类，
     * 然后消费者可以一直在监听。
     */
    @Test
    public void Test() {
        System.out.println("redis队列测试");
        producer.sendMessage(new AnnouncementMessage("1", "aaaa"));
        producer.sendMessage(new AnnouncementMessage("2", "bbbb"));
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

