package com.hibernate.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class UserDetails extends User {
	@Column(name="First_Name")
	private String first_Name;
	@Column(name="Last_Name")
	private String last_Name;
	@Embedded
	private Address addr;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name = "Phone", joinColumns = @JoinColumn(name = "User_ID"))
	@Column(name="Phone_Number")//WIll create a new table with userdetails having no reference but phone table having User id
	private List<Long> ph_no;
	
	@Column(name="Gender")
	private char gender;
	@Column(name="Marital_Status")
	private boolean maritalStatus;
	@Column(name="DOB")
	private Date birthDate;
	
	@OneToOne
	@JoinColumn(name="Vehicle_ID")
	private Vehicle trans;//one entity inside other -Userdetails have a foreign key to Table vehicle
	
	@OneToMany
	//TO change COlumn name in the new table created userdetails_laptop having the mapping
	@JoinTable(name="O2M_USER_LAPTOP",joinColumns=@JoinColumn(name="User_ID"),
	inverseJoinColumns=@JoinColumn(name="Laptop_ID"))
	private List<Laptop> lapi=new ArrayList<Laptop>();//We will have a 
	
	@ManyToMany
	private List<Roles> rol=new ArrayList<>();
	
	public Vehicle getTrans() {
		return trans;
	}

	public void setTrans(Vehicle trans) {
		this.trans = trans;
	}

	public UserDetails() {
		ph_no = new ArrayList<Long>();
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public List<Long> getPh_no() {
		return ph_no;
	}

	public void setPh_no(List<Long> ph_no) {
		this.ph_no = ph_no;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public List<Roles> getRol() {
		return rol;
	}

	public void setRol(List<Roles> rol) {
		this.rol = rol;
	}

	public boolean isMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(boolean maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Laptop> getLapi() {
		return lapi;
	}

	public void setLapi(List<Laptop> lapi) {
		this.lapi = lapi;
	}
}
