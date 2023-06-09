package com.demo.design.mode_b_structure.d_bridging;

/**
 * 扩充抽象类。
 * 动物园
 * 脱耦：脱耦就是将抽象化和实现化之间的耦合解脱开，或者说是将它们之间的强关联改换成弱关联，将两个角色之间的继承关系改为关联关系
 */
public class ZooPlace extends Place {

    private String name;

    public ZooPlace(String name, BuildAPI builder) {
        super(builder);
        this.name = name;
    }

    @Override
    public void build() {
        builder.build(name);
    }
}