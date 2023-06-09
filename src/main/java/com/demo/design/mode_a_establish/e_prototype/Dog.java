package com.demo.design.mode_a_establish.e_prototype;

/**
 * ConcretePrototype：具体原型类
 */
public class Dog extends Animal {
    public Dog() {
        type = "犬科动物";
    }

    @Override
    void say() {
        System.out.println(String.format("dog say %s","旺旺！"));
    }
}