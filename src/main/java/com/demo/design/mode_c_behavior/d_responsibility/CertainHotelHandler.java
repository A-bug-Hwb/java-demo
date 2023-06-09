package com.demo.design.mode_c_behavior.d_responsibility;

/**
 * ConcreteHandler: 具体处理者
 * 旅馆
 */
public class CertainHotelHandler extends Handler {
    public CertainHotelHandler(String level) {
        super(level);
    }

    @Override
    public void handelRequest(String level, String name) {
        if(this.level.equals(level)){
            System.out.println("客人為外交部長級別，請在旅館下榻");
        }else{
            this.nextHandler.handelRequest(level, name);
        }
    }

}