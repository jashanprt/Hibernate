package com.hibernate.entity;

import javax.persistence.Column;

public class TwoWheeler extends Vehicle{

	@Column(name="TyreCount")
	public String numberOfTyres;
}
