package com.culqui.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardBinlist {

	private Number number;
	private String scheme;
	private String type;
	private String brand;
	private String prepaid;
	private Country country;
	private Bank bank;
	
	
	public CardBinlist() {
		super();
	}
	
	public CardBinlist(Number number, String scheme, String type, String brand, String prepaid, Country country,
			Bank bank) {
		super();
		this.number = number;
		this.scheme = scheme;
		this.type = type;
		this.brand = brand;
		this.prepaid = prepaid;
		this.country = country;
		this.bank = bank;
	}
	
	public Number getNumber() {
		return number;
	}
	
	public void setNumber(Number number) {
		this.number = number;
	}
	
	public String getScheme() {
		return scheme;
	}
	
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getPrepaid() {
		return prepaid;
	}
	
	public void setPrepaid(String prepaid) {
		this.prepaid = prepaid;
	}
	
	public Country getCountry() {
		return country;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public Bank getBank() {
		return bank;
	}
	
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	@Override
	public String toString() {
		return "CardBinlist [number=" + number + ", scheme=" + scheme + ", type=" + type + ", brand=" + brand
				+ ", prepaid=" + prepaid + ", country=" + country + ", bank=" + bank + "]";
	}
}
