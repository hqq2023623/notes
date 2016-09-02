package com.zj.effective.chapter02;

/**
 * 使用枚举代替int常量<br/>
 * RuleNO20 : 坚持使用@Override <br/>
 * RuleNO21 : 参数类型优先使用接口<br/>
 * RuleNO22 : 对于boolean参数优先使用两个值的enum <br/>
 * RuleNO23 : 慎用可变参数 <br/>
 * RuleNO24 : 返回零长度的数组或者集合而不是null <br/>
 * RuleNO25 : 为所有导出的API元素编写注释文档 <br/>
 * RuleNO26 : 将局部变量的作用域最小化 <br/>
 * RuleNO27 : 如果需要精确的数字避免使用float和double,用long和BigDecimal<br/>
 * RuleNO28 : 如果其他类型更合适,尽量避免使用字符串<br/>
 * RuleNO29 : 通过接口引用对象<br/>
 * RuleNO30 : 
 * 
 * @author lzj 2015年10月30日
 */
public class RuleNO13 {

	enum Foods {
		apple("苹果"), banner("香蕉");
		private Foods(String name) {
			this.name = name;
		}

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	enum Operartion {
		PLUS("+") {
			double apply(double x, double y) {
				return x + y;
			}
		};
		abstract double apply(double x, double y);

		private final String symbol;

		public String getSymbol() {
			return symbol;
		}

		private Operartion(String symbol) {
			this.symbol = symbol;
		}
	}

}
