package com.demo.design.mode_c_behavior.k_interpreter;

/**
 * Context: 环境类
 */
public class Context {
    NonterminalExpression nonterminalExpression;

    public Context(){
        nonterminalExpression = new NonterminalExpression();
    }

    public void takeSubway(String s) {
        String[] strings = s.split("，");
        if(nonterminalExpression.interpretOld(s)){//60岁及以上，包括60岁
            System.out.println(String.format("%s 判斷為老人，此處乘車免費",s));
        }else if(nonterminalExpression.interpretStudent(s)){//18岁及以下，包括18岁
            System.out.println(String.format("%s 判斷為中小學生，此處乘車半價",s));
        }else{
            System.out.println(String.format("%s 判斷為社會普通人士，此處乘車全價",s));
        }
    }
}