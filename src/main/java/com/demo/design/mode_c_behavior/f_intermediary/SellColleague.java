package com.demo.design.mode_c_behavior.f_intermediary;

/**
 * 房地產商
 * 4）ConcreteColleague 具体的同事类，会有很多，每个同事只知道自己的行为，而不了解其他同事类的行为（方法），但是他们都是依赖中介者对象。
 */
public class SellColleague extends Colleague {

    public SellColleague(String type) {
        super(type);
    }

    @Override
    public void sendMsg(String msgType,String msg) {
        if("VIP".equals(msgType)){
            getMediator().sendMsgToVIP(msg);
        }
        else if("NOTVIP".equals(msgType)){
            getMediator().sendMsgToNOTVIP(msg);
        }
        else if("ALL".equals(msgType)){
            getMediator().sendMsgToALLCUSTOMER(msg);
        }
    }
}