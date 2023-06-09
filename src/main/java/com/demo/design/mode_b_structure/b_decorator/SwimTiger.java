package com.demo.design.mode_b_structure.b_decorator;

/**
 * ConcreteDecorator: 具体装饰类
 */
public class SwimTiger extends SuperTiger {
    public SwimTiger(Birds birds) {
        super(birds);
    }

    @Override
    public void play() {
        super.play();
        swim();
    }

    public  void  swim(){
        System.out.println(String.format("tiger can swim"));
    }
}