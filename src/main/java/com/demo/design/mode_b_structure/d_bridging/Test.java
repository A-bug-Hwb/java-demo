package com.demo.design.mode_b_structure.d_bridging;

public class Test {

    public static void main(String[] args) {
        Place chineseZoo = new ZooPlace("动物园",new ChineseBuilder());
        chineseZoo.build();
        Place americanZoo = new ZooPlace("动物园",new AmericanBuilder());
        americanZoo.build();
        Place chineseCircus = new CircusPlace("马戏团", new ChineseBuilder());
        chineseCircus.build();
    }
}
