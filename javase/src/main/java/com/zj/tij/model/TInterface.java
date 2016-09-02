package com.zj.tij.model;

import org.junit.Test;

/**
 * 接口的嵌套:接口可以嵌套在其他类里面
 * 
 * @author lzj 2015年11月3日
 */
public class TInterface {

	public interface A {
		void f();
	}

	public interface B {
		void b();
	}

	class C implements A {
		public void f() {

		}
	}

	@Test
	public void test01() {

	}

}
