package com.culqui.entity;

public class Card {

	private String pan;
	private String exp_year;
	private String exp_month;
	
	public Card() {
		super();
	}

	public Card(String pan, String exp_year, String exp_month) {
		super();
		this.pan = pan;
		this.exp_year = exp_year;
		this.exp_month = exp_month;
	}

	public String getPan() {
		return pan;
	}
	
	public void setPan(String pan) {
		this.pan = pan;
	}
	
	public String getExp_year() {
		return exp_year;
	}
	
	public void setExp_year(String exp_year) {
		this.exp_year = exp_year;
	}
	
	public String getExp_month() {
		return exp_month;
	}
	
	public void setExp_month(String exp_month) {
		this.exp_month = exp_month;
	}
	
	@Override
	public String toString() {
		return "Tarjeta [pan=" + pan + ", exp_year=" + exp_year + ", exp_month=" + exp_month + "]";
	}
		
}
