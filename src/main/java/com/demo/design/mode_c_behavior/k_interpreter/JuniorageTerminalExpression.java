package com.demo.design.mode_c_behavior.k_interpreter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TerminalExpression: 终结符表达式
 * 年龄小
 */
public class JuniorageTerminalExpression implements Expression {
    @Override
    public boolean interpretElder(String s) {
        return false;
    }

    @Override
    public boolean interpretStudent(String s) {
        String reg = "[0-9]*[1-9][0-9]*";
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(s);
        matcher.find();
        int years = Integer.valueOf(matcher.group());
        return years <= 18;
    }
}