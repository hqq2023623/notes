package com.zj.prototype018;

public class TestPrototype {

    public static void main(String[] args) {
        Manager manager = new Manager();
        UnderlinePen pen = new UnderlinePen('~');

        MessageBox box = new MessageBox('*');
        MessageBox box2 = new MessageBox('/');

        manager.register("strong message", pen);
        manager.register("warning box", box);
        manager.register("slash box", box2);

        //实现产生
        Product p1 = manager.create("strong message");
        p1.use("Hello World");

        Product p2 = manager.create("warning box");
        p2.use("Hello World");

        Product p3 = manager.create("slash box");
        p3.use("Hello World");

    }


}
