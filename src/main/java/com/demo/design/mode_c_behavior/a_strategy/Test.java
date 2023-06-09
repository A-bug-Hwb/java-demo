package com.demo.design.mode_c_behavior.a_strategy;

public class Test {

    public static void main(String[] args) {
        Context context = new Context(new BusTraffic());
        context.excuteStrategy("小明");

        System.out.println("-------不同的人选择不同的出行模式----------");

        Context context1 = new Context(new PlaneTraffic());
        context1.excuteStrategy("小刘");
    }
}
