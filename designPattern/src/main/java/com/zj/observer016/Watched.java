package com.zj.observer016;

/**
 * 管理受管理的观察者
 */
public interface Watched {

    void addWatcher(Watcher watcher);

    void removeWatcher(Watcher watcher);

    //这里一般是用Object类型 , 讲解的时候用String
    void notifyWatchers(String str);


}
