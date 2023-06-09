package com.demo.design.mode_b_structure.b_decorator;

/**
 * ConcreteComponent: 具体构件
 */
public class Tiger implements Birds {
    @Override
    public void play() {
        System.out.println(String.format("tiger can run"));
    }
}