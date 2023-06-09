package com.demo.design.mode_a_establish.a_factory_method;

import com.demo.design.mode_a_establish.a_factory_method.factory.CatFactory;
import com.demo.design.mode_a_establish.a_factory_method.factory.DogFactory;
import com.demo.design.mode_a_establish.a_factory_method.simple.AnimalFactory;

/**
 * 工厂方法模式
 */
public class Test {

    public static void main(String[] args) {

        //简单工厂
        AnimalFactory animalFactory = new AnimalFactory();
        animalFactory.say("Cat");
        animalFactory.say("Dog");

        //虽然符合了开闭原则, 但类会增多
        Animal c2 = new CatFactory().createAnimal();
        Animal d2 = new DogFactory().createAnimal();
        c2.say();
        d2.say();
    }
}
