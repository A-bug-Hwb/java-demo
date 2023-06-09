package com.demo.design.mode_c_behavior.e_visitor;

/**
 * Element 定义一个接受访问操作(accept())，它以一个访问者(Visitor)作为参数。
 */
public abstract class Birds {
    private String name;
    //品种
    private String breed;
    //性格
    private String disposition;

    public abstract void accept(Vistor vistor);


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

}