package zj.sync.helper.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch：在完成一组正在其他线程中执行的操作之前，它允许线程一直等待。<br/>
 * 视频会议模拟<br/>
 *
 * @author Lzj Created on 2016/3/17.
 */
public class Videoconference implements Runnable {

    private final CountDownLatch controller;

    public Videoconference(int count) {
        controller = new CountDownLatch(count);
    }

    @Override
    public void run() {
        //打印出这次这次会议的与会者人数
        System.out.println("VideoConference: Initialization " + controller.getCount());
        try {
            //等待所有的与会者到达
            controller.await();
            //到达后
            System.out.println("All have come...Let's start...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //每有一个与会者进入视频会议的时候，这个方法将被调用
    public void arrive(String name) {
        System.out.println(name + " has arrived");
        controller.countDown();
        //打印出还没有到达的与会者的数目
        System.out.println("VideoConference: Waiting for " + controller.getCount() + "  participants.");
    }


}
