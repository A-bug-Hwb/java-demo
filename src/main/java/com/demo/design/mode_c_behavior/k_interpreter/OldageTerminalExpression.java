package com.demo.design.mode_c_behavior.k_interpreter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TerminalExpression: 终结符表达式
 * 年龄大
 */
public class OldageTerminalExpression implements Expression {
    @Override
    public boolean interpretElder(String s) {
//        String reg = "[0-9]*[1-9][0-9]*";
        String reg = "\\d+";
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(s);
        matcher.find();
        int years = Integer.valueOf(matcher.group());
        return years >= 60;
    }

    @Override
    public boolean interpretStudent(String s) {
        return false;
    }
}