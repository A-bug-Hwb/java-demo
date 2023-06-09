package com.demo.design.mode_b_structure.b_decorator;

public class Test {

    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        SuperTiger flyTiger = new FlyTiger(tiger);
        SuperTiger swimTiger = new SwimTiger(flyTiger);
        swimTiger.play();
    }
}
