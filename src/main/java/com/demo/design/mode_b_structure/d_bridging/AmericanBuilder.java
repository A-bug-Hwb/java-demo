package com.demo.design.mode_b_structure.d_bridging;

public class AmericanBuilder implements BuildAPI{

    @Override
    public void build(String placeName) {
        String buildCat = "贝鲁猫";
        String buildDog = "贝鲁狗";
        System.out.println(String.format("美国人建造的%s selected %s and %s",placeName,buildCat,buildDog));
    }
}