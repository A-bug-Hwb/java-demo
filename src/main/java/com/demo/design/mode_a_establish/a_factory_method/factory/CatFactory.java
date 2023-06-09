package com.demo.design.mode_a_establish.a_factory_method.factory;

import com.demo.design.mode_a_establish.a_factory_method.Animal;
import com.demo.design.mode_a_establish.a_factory_method.AnimalFactory;
import com.demo.design.mode_a_establish.a_factory_method.Cat;

/**
 * 猫工厂类
 */
public class CatFactory implements AnimalFactory {

    /**
     * 创建猫
     */
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}