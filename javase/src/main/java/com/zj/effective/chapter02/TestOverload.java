package com.zj.effective.chapter02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * 重载方法的执行,重载方法的选择是静态的
 * 
 * @author lzj 2015年10月30日
 */
public class TestOverload {

	public void a(List<?> list) {
		System.out.println("list");
	}

	public void a(Set<?> set) {
		System.out.println("set");
	}

	public void a(Collection<?> coll) {
		System.out.println("collection");
	}

	@Test
	public void test01() {
		Collection<?>[] c = { new ArrayList<String>(), new HashSet<String>(),
				new HashMap<String, Object>().values() };
		for (Collection<?> cc : c) {
			a(cc);
		}
	}

}
