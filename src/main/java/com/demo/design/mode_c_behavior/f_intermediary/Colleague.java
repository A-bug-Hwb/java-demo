package com.demo.design.mode_c_behavior.f_intermediary;

/**
 * 2）Colleague 是抽象同事类。
 */
public abstract class Colleague {
    private String type;//註冊者類型
    private String name;//代號名稱
    private Mediator mediator;

    public abstract void sendMsg(String msgType,String msg);

    public void getMsg(String msg){
        System.out.println(String.format("%s %s 獲得消息：%s",getType(),getName(),msg));
    }

    public Colleague(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}