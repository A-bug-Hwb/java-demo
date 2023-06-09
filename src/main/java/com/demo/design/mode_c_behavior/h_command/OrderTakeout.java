package com.demo.design.mode_c_behavior.h_command;

/**
 * ConcreteCommand：定义一个接收者和行为之间的弱耦合；实现execute()方法，负责调用接收者的相应操作。
 */
public class OrderTakeout implements Command {
    private Receiver receiver;

    public OrderTakeout(Receiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        receiver.order();
    }
}