package com.demo.design.mode_a_establish.a_factory_method.simple;

public class AnimalFactory {

    public AnimalSimple say(String name) {
        if(name.equalsIgnoreCase("Cat")) {
            return new CatSay();
        }
        else if(name.equalsIgnoreCase("Dog")) {
            return new DogSay();
        }
        return null;
    }
}
