package com.demo.design.mode_c_behavior.k_interpreter;

/**
 * AbstractExpression: 抽象表达式
 */
public interface Expression {
    boolean interpretElder(String s);
    boolean interpretStudent(String s);
}