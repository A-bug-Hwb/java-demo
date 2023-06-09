package com.demo.design.mode_a_establish.d_builder;

public abstract class Builder {
    protected Zoo zoo = new Zoo();

    public abstract void selectCat();
    public abstract void selectDog();

    public Zoo getResult(){
        return zoo;
    }
}
