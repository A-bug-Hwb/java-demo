package com.demo.design.mode_b_structure.c_agent;

public class Test {

    public static void main(String[] args) {
        Pet pet = new ProxyPet(new DogPet());
        pet.BuyDog();
    }
}
