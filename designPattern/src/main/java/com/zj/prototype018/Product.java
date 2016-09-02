package com.zj.prototype018;

public interface Product extends Cloneable {
	
	void use(String s);
	Product createClone();
	
}
