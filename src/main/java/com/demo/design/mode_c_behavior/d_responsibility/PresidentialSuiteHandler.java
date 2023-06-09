package com.demo.design.mode_c_behavior.d_responsibility;

/**
 * ConcreteHandler: 具体处理者
 * 总统套房
 */
public class PresidentialSuiteHandler extends Handler {
    public PresidentialSuiteHandler(String level) {
        super(level);
    }

    @Override
    public void handelRequest(String level, String name) {
        if(this.level.equals(level)){
            System.out.println("客人為總統級別，請在總統套房下榻");
        }else{
            this.nextHandler.handelRequest(level, name);
        }
    }
}