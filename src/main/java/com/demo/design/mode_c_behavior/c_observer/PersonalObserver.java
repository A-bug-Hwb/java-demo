package com.demo.design.mode_c_behavior.c_observer;

/**
 * ConcreteObserver: 具体观察者
 */
public class PersonalObserver implements Observer{
    private float price;
    private float range;

    @Override
    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "PersonalObserver{" +
                "price=" + price +
                ", range=" + range +
                '}';
    }

    @Override
    public void update(float price,float range) {
        this.price = price;
        this.range = range;
    }
}