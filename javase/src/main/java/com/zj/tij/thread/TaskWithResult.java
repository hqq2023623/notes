package com.zj.tij.thread;

import java.util.concurrent.Callable;

/**
 * 可以带返回值的线程任务
 * 
 * @author lzj 2015年11月3日
 */
public class TaskWithResult implements Callable<String> {

	private int id;

	public TaskWithResult(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String call() throws Exception {
		return "result of TaskWithResult " + id;
	}

}
