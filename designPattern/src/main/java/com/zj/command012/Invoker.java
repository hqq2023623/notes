package com.zj.command012;

public class Invoker {

    private Command command = null;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void runCommand() {
        System.out.println("Invoker.runCommand");
        command.execute();
    }

}
