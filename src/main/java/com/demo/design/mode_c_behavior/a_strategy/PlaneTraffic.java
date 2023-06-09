package com.demo.design.mode_c_behavior.a_strategy;

/**
 * ConcreteStrategy: 具体策略类
 */
public class PlaneTraffic implements Traffic {
    @Override
    public void getTraffic(String name) {
        System.out.println(String.format("%s选择乘坐飞机出行",name));
    }
}