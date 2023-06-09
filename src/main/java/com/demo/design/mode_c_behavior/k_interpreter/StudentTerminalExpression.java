package com.demo.design.mode_c_behavior.k_interpreter;

/**
 * TerminalExpression: 终结符表达式
 * 学生仔
 */
public class StudentTerminalExpression implements Expression {
    @Override
    public boolean interpretElder(String s) {
        return false;
    }

    @Override
    public boolean interpretStudent(String s) {
        return s.contains("學生") || s.contains("学生");
    }
}