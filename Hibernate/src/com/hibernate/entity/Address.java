package com.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(name="House_NO")
	private int house_no;
	@Column(name="Street_NO")
	private int street_no;
	@Column(name="Street")
	private String street;
	@Column(name="Town")
	private String town;
	@Column(name="City")
	private String city;
	@Column(name="State")
	private String State;
	@Column(name="Country")
	private String country;
	@Column(name="Pincode")
	private int pincode;
	
	
	public int getHouse_no() {
		return house_no;
	}
	public void setHouse_no(int house_no) {
		this.house_no = house_no;
	}
	public int getStreet_no() {
		return street_no;
	}
	public void setStreet_no(int street_no) {
		this.street_no = street_no;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
}
