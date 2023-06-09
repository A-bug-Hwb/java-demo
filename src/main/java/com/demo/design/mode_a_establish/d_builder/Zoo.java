package com.demo.design.mode_a_establish.d_builder;

/**
 * 产品角色 动物园
 * 一个具体的产品对象。
 */
public class Zoo {
    private String cat;
    private String dog;

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getDog() {
        return dog;
    }

    public void setDog(String dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "cat='" + cat + '\'' +
                ", dog='" + dog + '\'' +
                '}';
    }
}