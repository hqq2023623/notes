package com.zj.prototype018;

import java.util.Hashtable;

public class Manager {
	
	//在这里完全没有出现MessageBox,UnderlinePen类的类名，代表着可以跟这些类分开单独修改
	//Product接口是Manager类跟其他类沟通的唯一桥梁
	
	private Hashtable showcase = new Hashtable();
	
	//把注册进来的用一个Hashtable来接收
	//HashMap更好
	public void register(String name, Product proto) {
		showcase.put(name, proto);
	}

	public Product create(String protoname) {
		Product p = (Product) showcase.get(protoname);
		return p.createClone();
	}

}
