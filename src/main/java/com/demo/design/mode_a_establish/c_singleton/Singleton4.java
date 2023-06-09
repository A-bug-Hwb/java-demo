package com.demo.design.mode_a_establish.c_singleton;

/**
 * 懒汉式(延迟加载)
 */
public class Singleton4 {

    private static volatile Singleton4 singleton4;

    public static Singleton4 getSingleton4Instance(){
        if (singleton4 == null){
            synchronized(Singleton4.class){
                //进入代码同步块之后，再判断，如果为空，再创建实例
                if (singleton4 == null){
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }

    public void handle(){
        //to do something
    }
}
