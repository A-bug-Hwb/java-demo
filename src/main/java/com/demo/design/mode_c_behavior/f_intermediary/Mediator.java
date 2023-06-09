package com.demo.design.mode_c_behavior.f_intermediary;

/**
 * 1）Mediator 就是抽象中介者，定义类同事对象到中介者对象的接口。
 */
public interface Mediator {
    /**
     * 成员注册
     * @param name
     * @param colleague1
     */
    void registor(String name, Colleague colleague1);

    /**
     * 发送消息给VIP客户
     * @param msg
     */
    void sendMsgToVIP(String msg);
    /**
     * 发送消息给非VIP客户
     * @param msg
     */
    void sendMsgToNOTVIP(String msg);
    /**
     * 发送消息给所有客户
     * @param msg
     */
    void sendMsgToALLCUSTOMER(String msg);
    /**
     * 发送消息给销售员
     * @param msg
     */
    void sendMsgToSaleperson(String msg);
}