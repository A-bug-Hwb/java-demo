package com.demo.design.mode_a_establish.e_prototype;

import java.util.Hashtable;

/**
 * 原型模式（Prototype Pattern）是用于创建重复的对象，同时又能保证性能。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 * 优点： 1、性能提高。 2、逃避构造函数的约束。
 *
 * 缺点： 1、配备克隆方法需要对类的功能进行通盘考虑，这对于全新的类不是很难，但对于已有的类不一定很容易，特别当一个类引用不支持串行化的间接对象，或者引用含有循环结构的时候。 2、必须实现 Cloneable 接口。 3、逃避构造函数的约束。
 */
public class AnimalCache {
    private static Hashtable<String,Animal> map = new Hashtable<String,Animal>();

    public static Animal getAnimal(String id){
        Animal animal = map.get(id);
        return (Animal) animal.clone();
    }

    public static void loadCache(){
        Cat cat = new Cat();
        Dog dog = new Dog();
        map.put("1",cat);
        map.put("2",dog);
    }
}