package com.demo.design.mode_c_behavior.f_intermediary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 中介
 * 3）ConcreteMediator 具体的中介者对象，实现抽象方法，他需要知道所有的具体的同事类，即以一个集合来管理HashMap，并接收某个同事对象消息，完成相应的任务。
 */
public class HouseMediator implements Mediator {

    Map<String,Colleague> colleagueMap = new HashMap<String,Colleague>();

    @Override
    public void registor(String name, Colleague colleague) {
        colleagueMap.put(name,colleague);
        colleague.setMediator(this);
        colleague.setName(name);
    }

    public void sendMsgToVIP(String msg){
        colleagueMap.forEach((k,v)-> {
            if(v.getType().equals("VIP")){
                v.getMsg(msg);
            }
        });
    }

    @Override
    public void sendMsgToNOTVIP(String msg) {
        colleagueMap.forEach((k,v)-> {
            if(v.getType().equals("NOTVIP")){
                v.getMsg(msg);
            }
        });
    }

    @Override
    public void sendMsgToALLCUSTOMER(String msg) {
        colleagueMap.forEach((k,v)-> {
            if(v.getType().equals("VIP") || v.getType().equals("NOTVIP")){
                v.getMsg(msg);
            }
        });
    }

    @Override
    public void sendMsgToSaleperson(String msg) {
        colleagueMap.forEach((k,v)-> {
            if(v.getType().equals("SHELL")){
                v.getMsg(msg);
            }
        });
    }

}