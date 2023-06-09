package com.demo.design.mode_b_structure.b_decorator;

/**
 * ConcreteDecorator: 具体装饰类
 */
public class FlyTiger extends SuperTiger {
    public FlyTiger(Birds birds) {
        super(birds);
    }

    @Override
    public void play() {
        super.play();
        fly();
    }

    public void fly(){
        System.out.println(String.format("tiger can fly"));
    }
}