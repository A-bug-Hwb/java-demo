package com.demo.mq.RedisMq;

import com.demo.mq.RedisMq.service.MessageConsumerService;
import com.demo.mq.RedisMq.service.MessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @Author: crush
 * @Date: 2021-08-06 17:11
 * version 1.0
 */
public class MessageQueueTest {

    @Autowired
    private MessageProducerService producer;

    @Autowired
    private MessageConsumerService consumer;

    /**
     * 这个测时 的先启动主启动累，
     * 然后消费者可以一直在监听。
     */
    public void testQueue2() {
        producer.sendMessage(new AnnouncementMessage("1", "aaaa"));
        producer.sendMessage(new AnnouncementMessage("2", "bbbb"));
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

