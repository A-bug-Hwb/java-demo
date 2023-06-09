package com.demo.design.mode_b_structure.d_bridging;

/**
 * 马戏团
 * 将抽象部分与他的实现部分分离套用《大话设计模式》里面的就是实现系统可能有多个角度分类，每一种角度都可能变化，那么把这种多角度分类给分离出来让他们独立变化，减少他们之间耦合。
 */
public class CircusPlace extends Place {
    private String placeName;

    protected CircusPlace(String placeName, BuildAPI builder) {
        super(builder);
        this.placeName = placeName;
    }

    @Override
    public void build() {
        builder.build(placeName);
    }
}