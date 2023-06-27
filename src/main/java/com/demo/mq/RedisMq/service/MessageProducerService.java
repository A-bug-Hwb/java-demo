package com.demo.mq.RedisMq.service;

import com.demo.common.RedisCache;
import com.demo.mq.RedisMq.AnnouncementMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService {

//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RedisCache redisCache;

    private String queueKey="queue";

    public Long sendMessage(AnnouncementMessage message) {
        System.out.println("发送了" + message);
        return redisCache.redisTemplate.opsForList().leftPush(queueKey, message);
    }
}

