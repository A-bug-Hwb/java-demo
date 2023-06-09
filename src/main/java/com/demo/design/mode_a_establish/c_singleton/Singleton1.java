package com.demo.design.mode_a_establish.c_singleton;


/**
 * 饿汉式
 */
public class Singleton1 {

    private static volatile Singleton1 singleton = new Singleton1();;

    public static Singleton1 getSingletonInstance(){
        return singleton;
    }

    public void handle(){
        //to do something
    }
}
