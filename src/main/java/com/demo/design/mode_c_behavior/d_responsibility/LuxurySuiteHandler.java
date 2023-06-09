package com.demo.design.mode_c_behavior.d_responsibility;

/**
 * ConcreteHandler: 具体处理者
 * 豪华套房
 */
public class LuxurySuiteHandler extends Handler {
    public LuxurySuiteHandler(String level) {
        super(level);
    }

    @Override
    public void handelRequest(String level, String name) {
        if(this.level.equals(level)){
            System.out.println("客人為國務卿級別，請在豪華套房下榻");
        }else{
            this.nextHandler.handelRequest(level, name);
        }
    }
}