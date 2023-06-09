package com.demo.design.mode_c_behavior.d_responsibility;

/**
 * Handler: 抽象处理者
 */
public abstract class Handler {
    Handler nextHandler;
    String level;

    public Handler(String level) {
        this.level = level;
    }

    public void setNext(Handler handler) {
        nextHandler= handler;
    }

    public abstract void handelRequest(String level, String name);



}