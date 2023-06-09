package com.demo.design.mode_c_behavior.k_interpreter;

/**
 * NonterminalExpression: 非终结符表达式
 */
public class NonterminalExpression {
    private Expression oldageTerminalExpression;
    private Expression elderTerminalExpression;
    private Expression juniorageTerminalExpression;
    private Expression studentTerminalExpression;

    public NonterminalExpression() {
        oldageTerminalExpression = new OldageTerminalExpression();
        elderTerminalExpression = new ElderTerminalExpression();
        juniorageTerminalExpression = new JuniorageTerminalExpression();
        studentTerminalExpression = new StudentTerminalExpression();
    }

    public boolean interpretOld(String s) {
        String[] strings = s.split("，");
        return oldageTerminalExpression.interpretElder(strings[0]) && elderTerminalExpression.interpretElder(strings[1]);
    }

    public boolean interpretStudent(String s) {
        String[] strings = s.split("，");
        return juniorageTerminalExpression.interpretStudent(strings[0]) && studentTerminalExpression.interpretStudent(strings[1]);
    }
}