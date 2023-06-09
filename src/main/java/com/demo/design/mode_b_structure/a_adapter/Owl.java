package com.demo.design.mode_b_structure.a_adapter;

/**
 * 飞禽实现类，鹰会飞
 */
public class Owl implements FlyBirds {
    @Override
    public void playFly(String name) {
        System.out.println(String.format("%s can fly",name));
    }

    @Override
    public void playSwim(String name) {
        // not do something
    }
}