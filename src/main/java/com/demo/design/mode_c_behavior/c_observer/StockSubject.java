package com.demo.design.mode_c_behavior.c_observer;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteSubject: 具体目标
 */
public class StockSubject implements Subject{
    private float price;
    private float range;

    private List<Observer> observerList;

    public StockSubject(float price, float range) {
        this.price = price;
        this.range = range;
        this.observerList = new ArrayList<>();
    }

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void changData(float price, float range) {
        this.price = price;
        this.range = range;
    }

    @Override
    public void notifyObserver() {
        observerList.forEach((Observer ob)->{
            ob.update(price,range);
            ob.display();
        });
    }
}