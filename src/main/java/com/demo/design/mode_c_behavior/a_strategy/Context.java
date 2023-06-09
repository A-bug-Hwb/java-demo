package com.demo.design.mode_c_behavior.a_strategy;

/**
 * Context: 环境类
 */
public class Context {
    private Traffic traffic;

    public Context(Traffic traffic){
        this.traffic = traffic;
    }

    public void excuteStrategy (String name){
        traffic.getTraffic(name);
    }
}