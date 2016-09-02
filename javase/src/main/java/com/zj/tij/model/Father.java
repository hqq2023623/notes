package com.zj.tij.model;

/**
 *
 * @author lzj 2015年11月3日
 */
public class Father {

	private int id;

	// protected:同包或者子类可以访问
	protected String name;

	// 向上转型的应用
	public void print(Father f) {
		f.printOwn();
	}

	// 父类独有的方法
	private void printOwn() {
		System.out.println("printOwn");
	}

	public Father() {
	}

	public Father(int id) {
		super();
		this.id = id;
		System.out.println("from Fathre -- id = " + id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
