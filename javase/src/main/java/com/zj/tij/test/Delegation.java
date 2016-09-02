package com.zj.tij.test;

import com.zj.tij.model.Son;

/**
 * 静态代理,通过组合的方式来让成员类实现方法
 * 
 * @author lzj 2015年11月3日
 */
public class Delegation {

	private Son s;

	// 代理方法
	public void say() {
		s.say();
	}

	public Son getS() {
		return s;
	}

	public void setS(Son s) {
		this.s = s;
	}

}
