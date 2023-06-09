package com.demo.design.mode_c_behavior.f_intermediary;

/**
 * 客戶
 * 4）ConcreteColleague 具体的同事类，会有很多，每个同事只知道自己的行为，而不了解其他同事类的行为（方法），但是他们都是依赖中介者对象。
 */
public class CustomerColleague extends Colleague {
    public CustomerColleague(String type) {
        super(type);
    }

    @Override
    public void sendMsg(String msgType,String msg) {
        getMediator().sendMsgToSaleperson(String.format("客戶%s，%s",getName(),msg));
    }

}