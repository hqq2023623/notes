package com.zj.strategy014;

/**
 * Created by LZJ on 2015/12/4.
 */
public class Client {

    public static void main(String[] args) {

        StrategyConsumer consumer = new StrategyConsumer();
        consumer.setStrategy(new Strategy1());
        consumer.doSth();
    }

}
