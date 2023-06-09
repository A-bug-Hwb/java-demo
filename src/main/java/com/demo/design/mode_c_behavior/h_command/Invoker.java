package com.demo.design.mode_c_behavior.h_command;

import java.util.ArrayList;
import java.util.List;

/**
 * Invoker：负责调用命令对象执行请求，相关的方法叫做行动方法。
 */
public class Invoker {
    List<Command> commands = new ArrayList<>();


    public void setCommand(Command command) {
        commands.add(command);
    }

    public void call() {
        commands.forEach((command -> command.execute()));
        commands.clear();//調用完之後需要清空
    }
}