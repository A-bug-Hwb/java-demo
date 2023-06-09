package com.demo.design.mode_c_behavior.f_intermediary;

public class Test {
    public static void main(String[] args) {
        Mediator mediator = new HouseMediator();

        Colleague colleague1 = new SellColleague("SHELL");//成员一 房地產商
        Colleague colleague2 = new CustomerColleague("VIP");//成员二 客戶
        Colleague colleague3 = new CustomerColleague("VIP");//成员三 客戶
        Colleague colleague4 = new CustomerColleague("NOTVIP");//成员四 客戶

        mediator.registor("中原地產",colleague1);
        mediator.registor("代號張三",colleague2);
        mediator.registor("代號李四",colleague3);
        mediator.registor("代號王五",colleague4);

        System.out.println("\n中介代發佈消息");
        colleague1.sendMsg("VIP","北京一環有一套房，優先提供給VIP客戶");

        System.out.println("\n中介代發佈消息II");
        colleague1.sendMsg("ALL","北京五環有十套房，優質高層大房");

        System.out.println("\n中介代發佈消息III");
        colleague2.sendMsg(null,"本人想要北京六環的90平方的房子");

    }
}
