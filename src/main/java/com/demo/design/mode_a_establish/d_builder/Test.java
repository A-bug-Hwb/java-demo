package com.demo.design.mode_a_establish.d_builder;

/**
 * 建造者模式
 */
public class Test {
    public static void main(String[] args) {
        AmericanBuilder builder = new AmericanBuilder();//美国建筑师
        ChineseBuilder builder1 = new ChineseBuilder();//中国建筑师

        Director director = new Director(builder);//指导者，需要指定建筑师
        Zoo zoo  = director.construct();//开始构建，返回构建的产品
        System.out.println(String.format("american 建造师建造的动物园： %s",zoo.toString()));//打印构建的结果

        Director director1 = new Director(builder1);
        Zoo zoo1 = director1.construct();
        System.out.println(String.format("chinese 建造师建造的动物园： %s",zoo1.toString()));
    }
}
