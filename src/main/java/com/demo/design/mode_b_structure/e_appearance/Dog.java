package com.demo.design.mode_b_structure.e_appearance;

/**
 * SubSystem:子系统角色
 */
public class Dog implements Animal {
    @Override
    public void say() {
        System.out.println("Dog say 旺旺~");
    }
}