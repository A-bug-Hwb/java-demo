package com.demo.design.mode_a_establish.d_builder;


public class ChineseBuilder extends Builder{
    @Override
    public void selectCat() {
        this.zoo.setCat("功夫猫");
    }

    @Override
    public void selectDog() {
        this.zoo.setDog("功夫狗");
    }
}
