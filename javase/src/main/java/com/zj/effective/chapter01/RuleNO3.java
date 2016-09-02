package com.zj.effective.chapter01;

import org.junit.Test;

/**
 * RuleNO3: 用私有构造器或者枚举类型强化Singleton属性 <br/>
 * 通过私有化构造器强化不可实例化的能力
 * 
 * @author lzj 2015年10月30日
 */
public class RuleNO3 {

	@Test
	public void test01() {
	}

}

class Singleton01 {
	private static final Singleton01 INSTANCE = new Singleton01();

	private Singleton01() {
	}

	public static Singleton01 getInstance() {
		return INSTANCE;
	}

}

class Singleton02 {

	private static class Instance {
		public static final Singleton02 INSTANCE = new Singleton02();
	}

	private Singleton02() {

	}

	public static Singleton02 getInstance() {
		return Instance.INSTANCE;
	}
}
