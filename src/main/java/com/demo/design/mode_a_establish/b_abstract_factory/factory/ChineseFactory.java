package com.demo.design.mode_a_establish.b_abstract_factory.factory;

import com.demo.design.mode_a_establish.b_abstract_factory.Animal;
import com.demo.design.mode_a_establish.b_abstract_factory.AnimalFactory;
import com.demo.design.mode_a_establish.b_abstract_factory.example.ChineseCat;
import com.demo.design.mode_a_establish.b_abstract_factory.example.ChineseDog;

public class ChineseFactory implements AnimalFactory {

    @Override
    public Animal getCat() {
        return new ChineseCat();
    }

    @Override
    public Animal getDog() {
        return new ChineseDog();
    }
}
