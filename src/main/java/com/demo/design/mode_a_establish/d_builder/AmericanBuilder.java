package com.demo.design.mode_a_establish.d_builder;


/**
 * 具体建造者
 * 实现抽象接口，构建和装配各个部件。
 */
public class AmericanBuilder extends Builder {
    @Override
    public void selectCat() {
        zoo.setCat("咖啡猫");
    }

    @Override
    public void selectDog() {
        zoo.setDog("咖啡狗");
    }
}
