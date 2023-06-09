package com.demo.design.mode_b_structure.b_decorator;

/**
 * Decorator: 抽象装饰类
 */
public abstract class SuperTiger implements Birds {
    private Birds birds;
    public SuperTiger(Birds birds){
        this.birds = birds;
    }

    @Override
    public void play() {
        birds.play();
    }
}