package com.demo.design.mode_c_behavior.b_template;

/**
 * ConcreteClass: 具体子类
 */
public class Oceanarium extends Trip {
    @Override
    public void enjoy() {
        System.out.println("观看海豚表演");
        System.out.println("观看海牛进食");
        System.out.println("玩旋转木马");
    }
}