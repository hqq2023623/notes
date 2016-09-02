package com.zj.effective.chapter02;

import java.io.File;
import java.io.FilenameFilter;

/**
 * RuleNO12 : 使类和成员的可访问性最小化 <br/>
 * RuleNO13 : 在共有类中使用访问方法而不是共有域<br/>
 * RuleNO14 : 使可变性最小<br/>
 * RuleNO15 : 组合优先于继承 <br/>
 * RuleNO16 : 接口优先于抽象类 <br/>
 * RuleNO17 : 优先考虑静态成员类 <br/>
 * RuleNO18 : 列表优先于数组
 * RuleNO19 : 优先考虑泛型和泛型方法
 * 
 * 
 * @author lzj 2015年10月30日
 */
public class RuleNO12 {

	// 为了使类成为不可变，要遵循下面五条规则：
	// 1.不要提供任何会修改对象状态的方法
	// 2.保证类不会被扩展
	// 3.使所有的域都是final的
	// 4.使所有的域都成为私有的
	// 5.确保对于任何可变组件的互斥访问。

	// 组合: 在新的类中增加一个私有域,它引用现有类的一个实例

	// 嵌套类(内部类--nested class)是指被定义在别的类内部的类
	// 其存在的目的是只为其外围的类(enclosing class)提供服务
	// 内部类有四种:
	// 静态成员类
	static class StaticInner {
		// 在没有外部类的实例的情况下实例化静态内部类是不可能的
	}

	// 非静态成员类
	class NonStaticInner {
	}

	// 局部类--定义在方法中
	public void tttt() {
		class LocalInner {
		}
		new LocalInner();
	}

	// 匿名类,可用lamdba表达式代替
	public void aaaa() {
		new FilenameFilter() {
			public boolean accept(File dir, String name) {
				boolean result = false;
				if ("lzj".equals(name)) {
					result = true;
				}
				return result;
			}
		};
	}

}
