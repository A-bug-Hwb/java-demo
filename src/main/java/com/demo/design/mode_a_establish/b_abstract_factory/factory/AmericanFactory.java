package com.demo.design.mode_a_establish.b_abstract_factory.factory;

import com.demo.design.mode_a_establish.b_abstract_factory.Animal;
import com.demo.design.mode_a_establish.b_abstract_factory.AnimalFactory;
import com.demo.design.mode_a_establish.b_abstract_factory.example.AmericanCat;
import com.demo.design.mode_a_establish.b_abstract_factory.example.AmericanDog;

public class AmericanFactory implements AnimalFactory {

    @Override
    public Animal getCat() {
        return new AmericanCat();
    }

    @Override
    public Animal getDog() {
        return new AmericanDog();
    }
}

