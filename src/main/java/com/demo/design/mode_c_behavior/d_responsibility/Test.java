package com.demo.design.mode_c_behavior.d_responsibility;

public class Test {
    public static void main(String[] args) {

        Handler handler1 = new PresidentialSuiteHandler("第一級別");//總統套房
        Handler handler2 = new LuxurySuiteHandler("第二級別");//豪華套房
        Handler handler3 = new CertainHotelHandler("第三級別");//旅館
        Handler handler4 = new GuestHouseHandler("第四級別");//招待所

        handler4.setNext(handler3);
        handler3.setNext(handler2);
        handler2.setNext(handler1);

        //责任链模式实现接待
        handler4.handelRequest("第一級別","总统拜登来访问");
        handler4.handelRequest("第二級別","國務卿布林肯來訪問");

        //打印信息如下
        //客人為總統級別，請在總統套房下榻
        //客人為國務卿級別，請在豪華套房下榻
    }
}
