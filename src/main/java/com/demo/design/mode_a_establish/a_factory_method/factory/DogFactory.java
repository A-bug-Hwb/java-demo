package com.demo.design.mode_a_establish.a_factory_method.factory;


import com.demo.design.mode_a_establish.a_factory_method.Animal;
import com.demo.design.mode_a_establish.a_factory_method.AnimalFactory;
import com.demo.design.mode_a_establish.a_factory_method.Dog;

/**
 * 狗工厂类
 */
public class DogFactory implements AnimalFactory {


    /**
     * 创建狗
     */
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}
