package com.demo.design.mode_b_structure.d_bridging;

/**
 * 实现类接口。
 * 建造者
 * 实现化：针对抽象化给出的具体实现。它和抽象化是一个互逆的过程，实现化是对抽象化事物的进一步具体化。
 */
public interface BuildAPI {
    void build(String placeName);
}