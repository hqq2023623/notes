package com.zj.tij.model;

import org.junit.Test;

import java.util.StringTokenizer;
import java.util.logging.Logger;

/**
 *
 * @author lzj 2015年11月3日
 */
public class TInner {

	class Inner1 {
		private void say() {
			System.out.println("Inner1");
			outter();
		}

		// 内部类返回外部类的引用
		public TInner out() {
			return TInner.this;
		}
	}

	// 通常在外部类声明一个方法返回一个内部类的引用
	public Inner1 getInner1() {
		return new Inner1();
	}

	// 内部类也可以访问
	private void outter() {
		System.out.println("outter");
	}

	@Test
	public void test01() {
		TInner t = new TInner();
		t.getInner1().say();
		// 生成内部类的方式:需要对应内部类的外部类的一个实例
		Inner1 i = t.new Inner1();
		Logger.getLogger("123").warning("123");
		String str = "lzj 12kk ,zxckzjcqpweo";
		StringTokenizer stok = new StringTokenizer(str);
		while (stok.hasMoreElements()) {
			// 两个方法是一样的
			System.out.println(stok.nextElement());
			System.out.println(stok.nextToken());
		}
	}

}
