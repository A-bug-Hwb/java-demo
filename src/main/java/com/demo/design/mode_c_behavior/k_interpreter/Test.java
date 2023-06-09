package com.demo.design.mode_c_behavior.k_interpreter;

public class Test {
    public static void main(String[] args) {

        Context context = new Context();
        //語法格式： 我今年?岁，我是学生xxx！
        context.takeSubway("我今年65岁，我是长者晏无师！");
        context.takeSubway("我今年10岁，我是學生小明！");
        context.takeSubway("我今年19岁，我是學生小黃！");
        context.takeSubway("我今年21岁，我是社青李四！");

        //打印信息如下
//        我今年65岁，我是长者晏无师！ 判斷為老人，此處乘車免費
//        我今年10岁，我是學生小明！ 判斷為中小學生，此處乘車半價
//        我今年19岁，我是學生小黃！ 判斷為社會普通人士，此處乘車全價
//        我今年21岁，我是社青李四！ 判斷為社會普通人士，此處乘車全價
    }
}
