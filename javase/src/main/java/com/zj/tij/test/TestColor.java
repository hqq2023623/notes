package com.zj.tij.test;

import com.zj.tij.model.Color;
import com.zj.tij.model.Father;
import com.zj.tij.model.Son;
import org.junit.Test;

/**
 *
 * @author lzj 2015年11月2日
 */
public class TestColor {

	// 枚举的使用
	@Test
	public void test01() {
		System.out.println(Color.GREEN);
		System.out.println(Color.GREEN.getName());
		System.out.println(Color.valueOf("GREEN"));
		for (Color c : Color.values()) {
			System.out.println(c.ordinal());
		}

		Color colors = Color.RED;

		switch (colors) {
		case GREEN:
			break;
		case RED:
			break;
		default:
			break;
		}
	}

	@Test
	public void testExtends() {
		Son s = new Son();
		s.setId(1);
		// 向上转型
		Father f = new Father();
		f.print(s);

	}

}
