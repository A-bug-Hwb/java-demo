package com.demo.design.mode_c_behavior.h_command;

public class Test {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();//调用者 发起人
        Receiver receiver = new Receiver();//命令接收者 处理人
        Command command1 = new OrderTakeout(receiver);//下单命令
        Command command2 = new DeliverTakeout(receiver);//送货命令
        Command command3 = new ReciveTakeout(receiver);//收取货物
        invoker.setCommand(command1);//调用者 发起下单命令（暂存）
        invoker.setCommand(command2);//调用者 发起送货命令（暂存）
        invoker.setCommand(command3);//调用者 发起收货命令（暂存）

        invoker.call();//一次性递交所有暂存命令

        //命令执行结果
//        下單成功，請及時送貨上門
//        正在送貨路上，路上堵車，會遲到10分鐘
//        已收到訂單，快遞時間有點久，不太滿意
    }
}
