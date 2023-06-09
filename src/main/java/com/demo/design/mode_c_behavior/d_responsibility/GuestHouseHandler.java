package com.demo.design.mode_c_behavior.d_responsibility;

/**
 * ConcreteHandler: 具体处理者
 * 招待所
 */
public class GuestHouseHandler extends Handler {
    public GuestHouseHandler(String level) {
        super(level);
    }

    @Override
    public void handelRequest(String level, String name) {
        if(this.level.equals(level)){
            System.out.println("客人為普通高管級別，請在招待所下榻");
        }else{
            this.nextHandler.handelRequest(level, name);
        }
    }
}