package com.demo.design.mode_a_establish.b_abstract_factory.example;

import com.demo.design.mode_a_establish.b_abstract_factory.abstract_class.Dog;

public class ChineseDog extends Dog {
    @Override
    public void say() {
        System.out.println(String.format("Chinese dog say %s","旺~~~旺~~~"));
    }
}
