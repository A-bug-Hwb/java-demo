package com.demo.design.mode_a_establish.b_abstract_factory.example;

import com.demo.design.mode_a_establish.b_abstract_factory.abstract_class.Cat;

public class AmericanCat extends Cat {
    @Override
    public void say() {
        System.out.println(String.format("American Cat say %s","喵~喵~"));
    }
}
