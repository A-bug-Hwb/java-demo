package com.demo.design.mode_c_behavior.h_command;

/**
 * Receiver：具体执行请求操作类，其具体方法叫行动方法。
 */
public class Receiver {
    public void order(){
        System.out.println("下單成功，請及時送貨上門");
    }
    public void deliver(){
        System.out.println("正在送貨路上，路上堵車，會遲到10分鐘");
    }
    public void receiver(){
        System.out.println("已收到訂單，快遞時間有點久，不太滿意");
    }
}