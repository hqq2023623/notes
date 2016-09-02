package com.zj.action.chapter05.synchronizer;

/**
 * Synchronizer是一个对象,它根据本身的状态调节线程的控制流<br/>
 * 阻塞队列算一种类型,其他还有信号量(samaphore)、关卡(barrier)、闭锁(latch)<br/>
 * Created by LZJ on 2015/12/8.
 */
public class Synchronizer04 {


    public static void main(String[] args) {

        //1.闭锁
        //闭锁可以延迟线程的进度直到线程终止
        //一个闭锁工作起来就像一道大门:直到闭锁到达终点状态之前,门一直是关闭的,没有线程能够通过
        //一旦到达终点状态,就不能够再改变状态了,所有线程都可以通过
        //可以用来确保特定活动在其他活动完成后才发生
        //1.等待--游戏中的玩家都准备后才可以开始游戏
        //2.确保一个服务不会开始,直到它依赖的服务都已经开始
        //3.确保一个计算不会执行,直到它需要的资源被初始化




    }


}
