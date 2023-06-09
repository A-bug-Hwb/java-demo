package com.demo.design.mode_b_structure.e_appearance;

/**
 * Facade: 外观角色
 */
public class AnimalFacade {
    private Cat cat;
    private Dog dog;
    public AnimalFacade(){
        this.cat = new Cat();
        this.dog = new Dog();
    }

    public void catSay(){
        cat.say();
    }

    public void dogSay(){
        dog.say();
    }


}