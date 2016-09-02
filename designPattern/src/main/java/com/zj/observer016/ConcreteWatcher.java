package com.zj.observer016;

/**
 * 观察者实现
 */
public class ConcreteWatcher implements Watcher {

    private String id;

    public ConcreteWatcher(String id) {
        this.id = id;
    }

    @Override
    public void update(String str) {
        System.out.println(str + "id = " + id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
