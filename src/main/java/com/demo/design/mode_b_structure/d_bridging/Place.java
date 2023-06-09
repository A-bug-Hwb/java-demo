package com.demo.design.mode_b_structure.d_bridging;

/**
 * 抽象类。
 * 场所
 * 抽象化：其概念是将复杂物体的一个或几个特性抽出去而只注意其他特性的行动或过程。在面向对象就是将对象共同的性质抽取出去而形成类的过程。
 */
public abstract class Place {
    protected BuildAPI builder;

    protected Place(BuildAPI builder) {
        this.builder = builder;
    }

    public abstract void build();
}