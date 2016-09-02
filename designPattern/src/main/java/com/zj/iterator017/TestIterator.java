package com.zj.iterator017;

public class TestIterator {

    public static void main(String[] args) {
        Aggregate ag = new ConcreteAggregate();
        ag.add("小明");
        ag.add("小红");
        ag.add("小刚");
        Iterator it = ag.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            System.out.println(str);
        }
    }

}
