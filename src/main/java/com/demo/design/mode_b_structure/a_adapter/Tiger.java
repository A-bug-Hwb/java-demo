package com.demo.design.mode_b_structure.a_adapter;

/**
 * Target：目标抽象类
 * 陆禽实现类 老虎会跑
 * 通过适配器实现 虎会飞，虎会游泳
 */
public class Tiger implements TerrestrialBirds {
    ForTigerAdapter forTigerAdapter;
    @Override
    public void play(String type, String name) {
        if(type.equals("run")){
            System.out.println(String.format("%s can %s",name,type));
        }
        else if(type.equals("fly")||type.equals("swim")){//调用适配器
            forTigerAdapter = new ForTigerAdapter(type);
            forTigerAdapter.play(type, name);
        }
        else{
            System.out.println(String.format("Invalid type. %s format not supported",type));
        }
    }
}