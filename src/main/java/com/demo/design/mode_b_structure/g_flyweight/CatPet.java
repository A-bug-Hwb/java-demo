package com.demo.design.mode_b_structure.g_flyweight;

/**
 * ConcreteFlyweight: 具体享元类
 */
public class CatPet implements Pet {
    public String color;
    public CatPet(String color){
        this.color = color;
    }
    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public void display(Animal animal) {
        System.out.println(String.format("%s 的 %s love eat %s",color,animal.getName(),animal.getFood()));
    }
}