package com.zj.prototype018;

public class MessageBox implements Product {

	private char decochar;

	public MessageBox(char decochar) {
		this.decochar = decochar;
	}
	
	//该方法用decochar把字符串框在里面
	@Override
	public void use(String s) {
		int length = s.getBytes().length;
		for (int i = 0; i < length + 4; i++) {
			System.out.print(decochar);
		}
		System.out.println("");
		System.out.println(decochar + " " + s + " " + decochar);

		for (int i = 0; i < length + 4; i++) {
			System.out.print(decochar);
		}
		System.out.println("");

	}
	
	//该方法调用java api的方法，是浅复制
	//该方法只能从本身的类（包含子类）调用，如果是因其他类的要求而进行复制的时候，就要用其他方法把clone()抓过来
	@Override
	public Product createClone() {
		Product p = null;
		try {
			p = (Product) clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
