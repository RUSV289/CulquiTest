package com.culqui.entity;

public class Number {
	
	private int length;
	private boolean luhn;
	
	
	public Number() {
		super();
	}
	
	public Number(int length, boolean luhn) {
		super();
		this.length = length;
		this.luhn = luhn;
	}

	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public boolean isLuhn() {
		return luhn;
	}
	
	public void setLuhn(boolean luhn) {
		this.luhn = luhn;
	}

	@Override
	public String toString() {
		return "Number [length=" + length + ", luhn=" + luhn + "]";
	}
	
}
