package com.demo.design.mode_b_structure.d_bridging;

/**
 * 具体实现类 。
 */
public class ChineseBuilder implements BuildAPI {
    @Override
    public void build(String placeName) {
        String buildCat = "风火猫";
        String buildDog = "风火狗";
        System.out.println(String.format("中国人建造的%s selected %s and %s",placeName,buildCat,buildDog));
    }
}