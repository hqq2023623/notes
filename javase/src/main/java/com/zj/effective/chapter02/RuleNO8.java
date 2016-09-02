package com.zj.effective.chapter02;

/**
 * RuleNO8: 覆盖equals时总要覆盖hashCode
 * RuleNO9: 始终要覆盖toString
 * RuleNO10: 谨慎地覆盖clone
 * RuleNO11: 考虑实现Comparable接口
 * @author lzj 2015年10月30日
 */
public class RuleNO8 {

	// 满足下列四个条件之一的就不需要覆盖equals方法：
	// (1).类的每个实例本质上都是唯一的，如枚举等。
	// (2).不关心类是否提供了“逻辑相等”的测试功能。
	// (3).超类已经覆盖了equals方法，从超类集成过来的行为对于子类也是合适的。
	// (4).类是私有的或者包访问权限的，可以确定它的equals方法永远不会被调用。
	// 当类具有自己特有的“逻辑相等”概念(不同于对象等同的概念)，而且超类还没有覆盖equals方法以实现期望的行为时，就需要覆盖equals方法。在覆盖equals方法时，必须遵循以下的通用约定：
	// (1).自反性(reflexive)：对于任何非null的引用值x，x.equals(x)必须返回true。
	// (2).对称性(symmetric)：对于任何非null的引用值x和y，当且仅当y.equals(x)返回true时，x.equals(y)必须返回true。
	// (3).传递性(transitive)：对于任何非null的引用值x，y和z，如果x.equals(y)返回true，且y.equals(z)返回true，那么x.equals(z)也必须返回true。
	// (4).一致性(consistent)：对于任何非null的引用值x和y，只有equals的比较操作在对象中所用的信息没有被修改，多次调用x.equals(y)总会一致地返回相同的结果。
	// (5).非空性(Non-nullity)：对于任何非null的引用值x，x.equals(null)必须返回false。

	// 在引用程序的执行期间，只要对象的equals方法的比较操作所用到的信息没有被修改，那么对这同一个对象调用多次，hashCode方法都必须始终如一的返回同一个整数。在一个应用程序的多次执行过程中，每次执行所返回的整数可以不一致。
	// 如果连个对象根绝equals方法比较是相等的，那么调用这两个对象中任意一个对象的hashCode方法都必须产生同样的整数结果。
	// 如果两个对象根据equals方法比较是不相等的，那么调用这两个对象中任意一个对象的hashCode方法，则不一定要蚕声不同的整数结果。但是程序员应该知道，给不相等的对象产生截然不同的整数结果，有可能提高散列表（hash
	// table）的性能。（比如，当你一个entity只根据id比较是否相等，但是在没实例化之前，没有id数值，那么默认的equals返回false，但是hashCode返回的值却相等。）
}
