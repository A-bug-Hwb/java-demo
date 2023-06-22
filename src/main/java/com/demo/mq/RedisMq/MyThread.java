package com.demo.mq.RedisMq;

import com.demo.mq.RedisMq.service.MessageConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: crush
 * @Date: 2021-08-06 22:17
 * version 1.0
 * ApplicationRunner:
 * 用于指示 bean 在包含在SpringApplication时应该运行的SpringApplication 。
 * 通俗说就是 在这个项目运行的时候，它也会自动运行起来。
 */
@Component
public class MyThread implements ApplicationRunner {

    @Autowired
    MessageConsumerService messageConsumerService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        messageConsumerService.start();
    }
}
