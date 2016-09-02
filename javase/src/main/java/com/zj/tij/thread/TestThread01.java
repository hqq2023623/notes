package com.zj.tij.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author lzj 2015年11月3日
 */
public class TestThread01 {

	@Test
	public void test01() {
		LiftOff l = new LiftOff();
		Thread t = new Thread(l);
		t.start();
		System.out.println("waiting for liftOff");
	}

	@Test
	public void test02() {
		for (int i = 0; i < 5; i++) {
			LiftOff l = new LiftOff();
			Thread t = new Thread(l);
			t.start();
		}
	}

	// 使用Executor
	@Test
	public void test03() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			executorService.execute(new LiftOff());
		}
		System.out.println("                       ");
		ExecutorService exec2 = Executors.newFixedThreadPool(5);
		exec2.execute(new LiftOff());
	}

	@Test
	public void test04() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		List<Future<String>> list = new ArrayList<Future<String>>();
		// 需要调用submit();
		for (int i = 0; i < 5; i++) {
			list.add(executorService.submit(new TaskWithResult(i)));
		}
		for (Future<String> str : list) {
			try {
				System.out.println(str.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				executorService.shutdown();
			}
		}
	}

}
