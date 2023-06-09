package com.demo.design.mode_b_structure.a_adapter;

/**
 * 飞禽实现接口 鸬鹚会游泳
 * 大型的食鱼游禽，善于潜水，潜水后羽毛湿透，需张开双翅在阳光下晒干后才能飞翔
 */
public class Cormorant implements FlyBirds{
    @Override
    public void playFly(String name) {
        //not do something
    }

    @Override
    public void playSwim(String name) {
        System.out.println(String.format("%s can swim",name));
    }
}