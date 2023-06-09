package com.demo.design.mode_b_structure.f_combination;

public class Cat extends Animal{
    public Cat(String name) {
        setName(name);
        animalList = null;//无下属
    }

    @Override
    public void add(Animal animal) {

    }

    @Override
    public void delete(Animal animal) {

    }
}