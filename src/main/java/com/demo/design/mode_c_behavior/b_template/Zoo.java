package com.demo.design.mode_c_behavior.b_template;

/**
 * ConcreteClass: 具体子类
 */
public class Zoo extends Trip {
    @Override
    public void enjoy() {
        System.out.println("观看兔子睡觉");
        System.out.println("观看鸭子戏水");
        System.out.println("玩蹦蹦床");
    }
}