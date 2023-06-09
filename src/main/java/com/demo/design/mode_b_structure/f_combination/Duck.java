package com.demo.design.mode_b_structure.f_combination;

/**
 * Leaf（叶子）
 *
 * 在组合中表示叶节点对象，叶节点没有子节点
 * 在组合中定义节点对象的行为
 */
public class Duck extends Animal {
    public Duck(String name) {
        setName(name);
        animalList = null;
    }

    @Override
    public void add(Animal animal) {

    }

    @Override
    public void delete(Animal animal) {

    }
}