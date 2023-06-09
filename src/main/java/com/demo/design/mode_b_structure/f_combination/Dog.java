package com.demo.design.mode_b_structure.f_combination;

import java.util.ArrayList;

public class Dog extends Animal {
    public Dog(String name){
        setName(name);
        animalList = new ArrayList<Animal>();//无下属
    }
    @Override
    public void add(Animal animal) {
        animalList.add(animal);
    }

    @Override
    public void delete(Animal animal) {
        animalList.remove(animal);
    }
}