package com.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Roles {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	@Column(name="Role")	
	private String roleName;

	@ElementCollection
	@JoinTable(name="COLL_Apps",joinColumns=@JoinColumn(name="Applications"))
	private List<String> accessApps=new ArrayList<>();
	
	@ManyToMany(mappedBy="rol")//Reference name in Userdetails for ROles
	private List<UserDetails> ul=new ArrayList<>();
	
	public List<UserDetails> getUl() {
		return ul;
	}

	public void setUl(List<UserDetails> ul) {
		this.ul = ul;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<String> getAccessApps() {
		return accessApps;
	}

	public void setAccessApps(List<String> accessApps) {
		this.accessApps = accessApps;
	}

}
