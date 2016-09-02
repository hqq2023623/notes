package com.zj.iterator017;

import java.util.ArrayList;
import java.util.List;

public class ConcreteIterator implements Iterator {

	private List list = new ArrayList();
	private int cursor = 0;

	public ConcreteIterator(List list) {
		this.list = list;
	}

	@Override
	public boolean hasNext() {
		return cursor != list.size();
	}

	@Override
	public Object next() {
		Object obj = null;
		if (this.hasNext()) {
			obj = this.list.get(cursor++);
		}
		return obj;
	}

}
