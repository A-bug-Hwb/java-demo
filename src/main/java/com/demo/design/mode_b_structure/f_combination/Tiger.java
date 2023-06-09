package com.demo.design.mode_b_structure.f_combination;

import java.util.ArrayList;

/**
 * Composite
 *
 * 定义有子部件的那些部件的行为。
 * 存储子部件。
 *
 * 在Component接口中实现与子部件有关的操作。
 */
public class Tiger extends Animal {
    public Tiger(String name) {
        setName(name);
        animalList = new ArrayList<Animal>();
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