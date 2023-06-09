package com.demo.design.mode_b_structure.f_combination;

import java.util.List;

/**
 * Component（组件）
 *
 * 为组合中的对象声明接口
 * 在适当的情况下，实现所有类共有接口的缺省行为
 * 声明一个接口用于访问和管理Component的子组件
 */
public abstract class Animal {
    private String name;
    protected List<Animal> animalList;
    public abstract void add(Animal animal);
    public abstract void delete(Animal animal);

    public void say(){
        System.out.println(String.format("name is %s",name));
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Animal> getSubAnimal(){
        return animalList;
    }
}