package com.zj.observer016;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理受管理的观察者
 */
public class ConcreteWatched implements Watched {

    //用一个集合来装观察者
    private List<Watcher> list = new ArrayList<Watcher>();

    @Override
    public void addWatcher(Watcher watcher) {
        list.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher) {
        list.remove(watcher);
    }

    @Override
    public void notifyWatchers(String str) {
        //通过遍历来进行通知,通知内容是传进来的参数
        for (Watcher watcher : list) {
            watcher.update(str);
        }
    }


}
