package com.zj.command012;

public class ConcreteCommand implements Command {

    private Receiver receiver = null;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    //交给receiver处理
    public void execute() {
        System.out.println("ConcreteCommand.execute");
        receiver.action();
    }

}
