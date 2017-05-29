package com.service;

public class Time {
	private int hour;
	private int minute;
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Time:"+hour+":"+minute;
	}
}
