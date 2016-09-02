package com.zj.tij.thread;

/**
 *
 * @author lzj 2015年11月3日
 */
public class LiftOff implements Runnable {

	protected int countDown = 10;

	private static int taskCount = 0;
	// 用来区分多个实例
	private final int id = taskCount++;

	public LiftOff() {
	}

	public LiftOff(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff") + ")";
	}

	public void run() {
		while (countDown-- > 0) {
			System.out.print(status());
			Thread.yield();
		}
	}

}
