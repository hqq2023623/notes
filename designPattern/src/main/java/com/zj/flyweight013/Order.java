package com.zj.flyweight013;

//一个咖啡店有几种口味的咖啡（拿铁、摩卡、卡布奇诺等等）
//如果这家店接到分订单要几十杯咖啡。那么显然咖啡的口味就可以设置成共享的，而不必为每一杯单独生成

public abstract class Order {

	// 执行卖出动作
	public abstract void sell();
	
}
