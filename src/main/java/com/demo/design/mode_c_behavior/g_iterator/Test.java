package com.demo.design.mode_c_behavior.g_iterator;

public class Test {
    public static void main(String[] args) {
        ConcreteAggregate aggregate = new ConcreteAggregate();
        Iterator iterator = aggregate.CreateIterator();

        while (!iterator.isDone()){
            String name = iterator.next();
            System.out.println(name);
        }
    }
}
