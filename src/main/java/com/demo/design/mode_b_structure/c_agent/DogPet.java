package com.demo.design.mode_b_structure.c_agent;

/**
 * RealSubject: 真实主题角色
 */
public class DogPet implements Pet {
    @Override
    public void BuyDog() {
        System.out.println("购买宠物狗！");
    }
}