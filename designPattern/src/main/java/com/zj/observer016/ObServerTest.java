package com.zj.observer016;

public class ObServerTest {

    public static void main(String[] args) {
        Watched underWatch = new ConcreteWatched();

        Watcher watcher1 = new ConcreteWatcher("1");
        Watcher watcher2 = new ConcreteWatcher("2");
        Watcher watcher3 = new ConcreteWatcher("3");

        underWatch.addWatcher(watcher1);
        underWatch.addWatcher(watcher2);
        underWatch.addWatcher(watcher3);

        underWatch.notifyWatchers("通知");

        underWatch.removeWatcher(watcher2);

        underWatch.notifyWatchers("删除了一个还剩下两个");


    }


}
