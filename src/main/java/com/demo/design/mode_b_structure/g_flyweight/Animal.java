package com.demo.design.mode_b_structure.g_flyweight;

/**
 * UnsharedConcreteFlyweight: 非共享具体享元类
 */
public class Animal {
    private String name;
    private String food;

    public Animal(String name,String food){
        this.name = name;
        this.food = food;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}