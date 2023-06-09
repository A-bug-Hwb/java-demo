package com.demo.design.mode_b_structure.c_agent;

/**
 * Proxy: 代理主题角色
 */
public class ProxyPet implements Pet {
    DogPet dogPet;
    public ProxyPet(DogPet dogPet) {
        this.dogPet = dogPet;
    }

    @Override
    public void BuyDog() {
        System.out.println("办理宠物证");
        dogPet.BuyDog();
        System.out.println("注射狂犬疫苗");
    }
}