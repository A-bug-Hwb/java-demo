package com.demo.design.mode_c_behavior.k_interpreter;

/**
 * TerminalExpression: 终结符表达式
 * 长辈
 */
public class ElderTerminalExpression implements Expression {
    @Override
    public boolean interpretElder(String s) {
        return s.contains("長者") || s.contains("长者");
    }

    @Override
    public boolean interpretStudent(String s) {
        return false;
    }
}