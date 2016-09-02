package com.zj.tij.test;

/**
 *
 * @author lzj 2015年10月31日
 */
public class Subject01 {

	private Subject01 sub1;

	private Subject01 sub2;

	{
		sub1 = new Subject01();
		sub2 = new Subject01();
	}

	Subject01() {
		System.out.println("Initialized 1 & 2");
	}

	public static void main(String[] args) {
		new Subject01();
	}

}
