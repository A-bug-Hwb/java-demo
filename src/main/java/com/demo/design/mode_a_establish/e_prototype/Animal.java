package com.demo.design.mode_a_establish.e_prototype;

/**
 * Prototype：抽象原型类
 */
public abstract class Animal implements Cloneable{
    protected String type;

    abstract void say();

    protected Object clone()  {
        Object clone = null;
        try {
            clone =  super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;

    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}