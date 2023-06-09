package com.demo.design.mode_b_structure.a_adapter;

public class Test {

    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        tiger.play("run","伏地虎");//原来伏地虎只会跑
        tiger.play("fly","伏地虎");//通过适配器实现伏地虎会飞
        tiger.play("swim","伏地虎");//通过适配器实现伏地虎会游泳
        tiger.play("jump","伏地虎");//暂未实现的行为
    }
}
