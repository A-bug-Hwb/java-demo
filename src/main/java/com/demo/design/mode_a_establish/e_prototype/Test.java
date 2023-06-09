package com.demo.design.mode_a_establish.e_prototype;

/**
 * 建造者模式
 */
public class Test {
    public static void main(String[] args) {
        AnimalCache.loadCache();
        Animal animal = AnimalCache.getAnimal("1");
        animal.say();
        System.out.println(String.format("动物所属科目 %s",animal.getType()));
        Animal anima2 = AnimalCache.getAnimal("2");
        anima2.say();
        System.out.println(String.format("动物所属科目 %s",anima2.getType()));
    }
}
