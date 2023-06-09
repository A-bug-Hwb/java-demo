package com.demo.design.mode_c_behavior.e_visitor;

/**
 * ConcreteElement 具体元素，实现了抽象元素(Element)所定义的接受操作接口。
 */
public class DogBirds extends Birds {

    //价格
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public void accept(Vistor vistor) {
        vistor.getPurpose(this);
        vistor.payPrice(this);
    }


}