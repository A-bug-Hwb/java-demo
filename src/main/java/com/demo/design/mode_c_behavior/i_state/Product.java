package com.demo.design.mode_c_behavior.i_state;

public class Product {
    String name;
    Float price;
    Integer num = 0; //产品总数，包括锁定数量
    Integer lockNum = 0;

    public Product(String name,Float price,Integer num){
        this.name = name;
        this.price = price;
        this.num = num;
    }

    public Integer getLockNum() {
        return lockNum;
    }

    public void setLockNum(Integer lockNum) {
        this.lockNum = lockNum;
    }
}