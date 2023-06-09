package com.demo.design.mode_c_behavior.c_observer;

public class Test {
    public static void main(String[] args) {
        Subject subject = new StockSubject(10f,0.0f);
        Observer observer = new PersonalObserver();
        Observer observer2 = new CompanyObserver();
        subject.attach(observer);
        subject.attach(observer2);
        System.out.println("初始化成功，通知觀察者");
        subject.notifyObserver();//初始化成功，通知主題訂閱者


        //float price,float range
        subject.changData(10.25f,2.5f);
        System.out.println("數據發生變更，通知觀察者");
        subject.notifyObserver();

        System.out.println(String.format("刪除觀察者%s",observer));
        subject.detach(observer);

        subject.changData(10.15f,1.5f);
        System.out.println("數據發生變更，通知觀察者");
        subject.notifyObserver();
    }
}
