package com.demo.design.mode_b_structure.g_flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * FlyweightFactory: 享元工厂类
 */
public class CatPetFlyWeightFactory {
    private static Map<String,Pet> map = new HashMap<String,Pet>();

    public static Pet getPet(String color){
        if(map.get(color) == null){
            Pet pet = new CatPet(color);
            map.put(color,pet);
        }
        return map.get(color);
    }
}