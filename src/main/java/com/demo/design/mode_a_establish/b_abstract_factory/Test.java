package com.demo.design.mode_a_establish.b_abstract_factory;


import com.demo.design.mode_a_establish.b_abstract_factory.factory.AmericanFactory;
import com.demo.design.mode_a_establish.b_abstract_factory.factory.ChineseFactory;

/**
 * 抽象工厂模式
 */
public class Test {

    public static void main(String[] args) {
        AnimalFactory americanFactory = new AmericanFactory();
        Animal cat = americanFactory.getCat();
        cat.say();
        Animal dog = americanFactory.getDog();
        dog.say();

        AnimalFactory chineseFactory = new ChineseFactory();
        Animal cat1 = chineseFactory.getCat();
        cat1.say();
        Animal dog1 = chineseFactory.getDog();
        dog1.say();
    }
}
