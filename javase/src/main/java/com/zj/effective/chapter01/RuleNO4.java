package com.zj.effective.chapter01;

import org.junit.Test;

/**
 * RuleNO4:避免创建不必要的对象<br/>
 * RuleNO5:消除过期的对象引用<br/>
 * RuleNO6:避免使用终结方法finalizer
 * 
 * @author lzj 2015年10月30日
 */
public class RuleNO4 {

	@Test
	public void test01() {
		// 这是对象
		String a = new String("a");
		// 这是常量
		String b = "b";
		// 这是对象
		String c = new String("cd");
		// 这是常量
		String d = "c" + new String("d");
		System.out.println(c == d);

		// 优先使用基本类型而不是装箱类型
		Integer x = 1;
		int y = 1;

	}

	// 过期引用：永远也不会被解除的引用,被栈弹出来的元素会在栈内部维护,所以不会被回收
	// 可以在弹出元素的时候立即 xxx = null;
	// 内存泄漏的来源： 1.缓存 2.监听器和其他回调
	//

}
