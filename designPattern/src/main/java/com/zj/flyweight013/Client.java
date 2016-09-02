package com.zj.flyweight013;

import java.util.ArrayList;
import java.util.List;

public class Client {

	// 客户下的订单
	private static List<Order> orders = new ArrayList<Order>();
	// 订单对象生成工厂
	private static FlavorFactory flavorFactory;
	// 增加订单
	private static void takeOrders(String flavor) {
	   orders.add(flavorFactory.getOrder(flavor));
	}
	public static void main(String[] args) {
	   // 订单生成工厂
	   flavorFactory = FlavorFactory.getInstance();
	   // 增加订单
	   takeOrders("摩卡");
	   takeOrders("卡布奇诺");
	   takeOrders("香草星冰乐");
	   takeOrders("香草星冰乐");
	   takeOrders("拿铁");
	   takeOrders("卡布奇诺");
	   takeOrders("拿铁");
	   takeOrders("卡布奇诺");
	   takeOrders("摩卡");
	   takeOrders("香草星冰乐");
	   takeOrders("卡布奇诺");
	   takeOrders("摩卡");
	   takeOrders("香草星冰乐");
	   takeOrders("拿铁");
	   takeOrders("拿铁");
	   // 卖咖啡
	   for (Order order : orders) {
	    order.sell();
	   }
	   // 打印生成的订单java对象数量
	   System.out.println("\n客户一共买了 " + orders.size() + " 杯咖啡! ");
	   // 打印生成的订单java对象数量
	   System.out.println("共生成了 " + flavorFactory.getTotalFlavorsMade()
	     + " 个 FlavorOrder java对象! ");
	}
	
	
	
	
}
