package com.demo.design.mode_a_establish.e_prototype;

/**
 * ConcretePrototype：具体原型类
 */
public class Cat extends Animal {
    public Cat() {
        type = "猫科动物";
    }

    @Override
    void say() {
        System.out.println(String.format("cat say %s","喵喵！"));
    }

}