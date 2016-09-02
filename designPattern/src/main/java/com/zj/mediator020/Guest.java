package com.zj.mediator020;

public class Guest {

	private boolean free;

	private Mediator med;

	public Guest(Mediator md) {
		this.med = md;
	}

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}

	// 通过中介者开始说话
	public void speak() {
		med.guestSpeak();

	}

	// 通过中介者停止说话
	public void stop() {
		med.guestStop();
	}

}
