package com.demo.mq.RedisMq.service;

import java.util.concurrent.TimeUnit;

import com.demo.mq.RedisMq.AnnouncementMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


/**
 * ApplicationRunner 实现这个接口可以跟随项目启动而启动
 * @author crush
 */
@Service
public class MessageConsumerService extends Thread {


    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    private volatile boolean flag = true;

    private String queueKey="queue";

    private Long popTime=1000L;

    @Override
    public void run() {
        try {
            AnnouncementMessage message;
            // 为了能一直循环而不结束
            while(flag && !Thread.currentThread().isInterrupted()) {
                message = (AnnouncementMessage) redisTemplate.opsForList().rightPop(queueKey,popTime,TimeUnit.SECONDS);
                System.out.println("接收到了" + message);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

}
