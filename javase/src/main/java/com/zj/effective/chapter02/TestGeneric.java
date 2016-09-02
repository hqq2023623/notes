package com.zj.effective.chapter02;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 泛型的使用
 * 
 * @author lzj 2015年10月30日
 */
public class TestGeneric<E> {

	@Test
	public void test01() {
		List<? extends RuleNO12> list = new ArrayList<RuleNO12>();
		list.get(0);
	}

	// 第一个<E>表示声明该方法为泛型方法,第二个为返回值,第三个为方法的参数
	static <E> List<E> asList(List<E> list) {
		return list;
	}

}
