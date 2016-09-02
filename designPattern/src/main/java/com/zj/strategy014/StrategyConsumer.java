package com.zj.strategy014;

/**
 * Created by LZJ on 2015/12/4.
 */
public class StrategyConsumer {

    private IStrategy strategy;

    public void doSth() {
        strategy.doSth();
    }

    public IStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }
}
