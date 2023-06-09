package com.demo.design.mode_b_structure.g_flyweight;

/**
 * Flyweight: 抽象享元类
 */
public interface Pet {
    /**
     * 内状态
     * @return
     */
    public String getColor();

    /**
     * 外状态
     * @param animal
     */
    public void display(Animal animal);
}