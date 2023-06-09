package com.demo.design.mode_c_behavior.b_template;

/**
 * AbstractClass: 抽象类
 */
public abstract class Trip {

    public final void play(){
        checkTicket();
        enterPark();
        enjoy();
        exitPark();
    }

    public void checkTicket(){
        System.out.println("检票");
    }

    public void enterPark(){
        System.out.println("入园");
    }

    public abstract void enjoy();

    public void exitPark(){
        System.out.println("出园");
    }
}