package com.demo.design.mode_b_structure.a_adapter;

/**
 * Adapter：适配器类
 * 适配器  属于结构型模式
 * 优点： 1、可以让任何两个没有关联的类一起运行。 2、提高了类的复用。 3、增加了类的透明度。 4、灵活性好。
 *
 * 缺点： 1、过多地使用适配器，会让系统非常零乱，不易整体进行把握。比如，明明看到调用的是 A 接口，其实内部被适配成了 B 接口的实现，一个系统如果太多出现这种情况，无异于一场灾难。因此如果不是很有必要，可以不使用适配器，而是直接对系统进行重构。 2.由于 JAVA 至多继承一个类，所以至多只能适配一个适配者类，而且目标类必须是抽象类。
 *
 */
public class ForTigerAdapter implements TerrestrialBirds{
    FlyBirds flyBirds;
    public ForTigerAdapter(String type){
        if("fly".equals(type)){
            flyBirds = new Owl();
        }
        else if("swim".equals(type)){
            flyBirds = new Cormorant();
        }

    }

    @Override
    public void play(String type, String name) {
        if("fly".equals(type)){
            flyBirds.playFly(name);
        }
        else if("swim".equals(type)){
            flyBirds.playSwim(name);
        }
    }
}