package com.zj.effective.chapter01;

/**
 * <p>
 * RuleNO2:遇到多个参数构造器时要考虑使用构建器
 * </p>
 * 
 * 
 * 
 * @author lzj 2015年10月30日
 */
public class RuleNO2 {

}

// 重叠构造器模式,参数一多就是个噩梦
class TelescopingConstructor {

	private String a;

	private String b;

	// 只需要调用参数最短的构造器
	public TelescopingConstructor(String a) {
		this(a, "");
	}

	public TelescopingConstructor(String a, String b) {
		this.a = a;
		this.b = b;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

}

// 建造者模式,使得参数具有名称,代码易读
class NutritionFacts {

	private final int a;

	private final int b;

	private final int c;

	// 打印成员变量总和
	public void printCount() {
		System.out.println(a + b + c);
	}

	public static class Builder {

		private final int a;

		private final int b;
		// 可以有多个可变参数
		private int c = 0;

		// 返回Builder本身,可以链式编程
		public Builder(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public Builder cal(int val) {
			c = val;
			return this;
		}

		public NutritionFacts build() {
			return new NutritionFacts(this);
		}

	}

	private NutritionFacts(Builder b) {
		this.a = b.a;
		this.b = b.b;
		this.c = b.c;
	}

	public static void main(String[] args) {
		NutritionFacts n = new Builder(10, 20).cal(30).build();
		n.printCount();
	}

}
