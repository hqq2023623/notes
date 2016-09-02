package com.zj.bridge015;

public class TestBridge {

    public static void main(String[] args) {

        Display d1 = new Display(new StringDisplayImpl("Hello ch"));

        Display d2 = new Display(new StringDisplayImpl("Hello World"));

        Display d3 = new Display(new StringDisplayImpl("Hello, Universe."));

        d1.display();
        System.out.println("---------d1--------");
        d2.display();
        System.out.println("---------d2--------");
        d3.display();
        d3.multiDisplay(5);
        System.out.println("---------d3--------");

    }


}
