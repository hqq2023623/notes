package com.zj.tij.model;

/**
 *
 * @author lzj 2015年11月2日
 */
public enum Color {

	RED("红色"), GREEN("绿色");

	private String name;

	private Color(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
