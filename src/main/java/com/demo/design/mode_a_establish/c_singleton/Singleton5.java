package com.demo.design.mode_a_establish.c_singleton;

/**
 * 静态内部类
 */
public class Singleton5 {

    public void handle(){
        // to do something
    }

    /**
     * 获取实例
     * @return
     */
    public static Singleton5 getSingletonInstance(){
        return SingletonHolder.singleton5;
    }

    /**
     * 内部类，JVM加载时是互斥的，可以保证线程安全
     */
    private static class SingletonHolder{
        private static final Singleton5  singleton5 = new Singleton5();
    }
}
