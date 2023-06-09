package com.demo.design.mode_c_behavior.g_iterator;

/**
 * Iterator: 抽象迭代器
 */
public interface Iterator {
    String first();
    String next();
    boolean isDone();
    String currentItem();
}