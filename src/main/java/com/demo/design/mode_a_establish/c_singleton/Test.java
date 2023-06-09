package com.demo.design.mode_a_establish.c_singleton;


/**
 * 单例模式
 */
public class Test {

    public static void main(String[] args) {
//        饿汉
        Singleton1 singleton1 = Singleton1.getSingletonInstance();
        singleton1.handle();

        //枚举方式
        Singleton6 singleton = Singleton6.SINGLETON;
        singleton.handle();

        //内部类实现
        Singleton5 singleton5 =  Singleton5.getSingletonInstance();
        singleton5.handle();

        //同步方法实现
        Singleton4 singleton4 =  Singleton4.getSingleton4Instance();
        singleton4.handle();
    }
}
