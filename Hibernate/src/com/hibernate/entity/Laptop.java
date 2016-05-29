package com.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Laptop {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String companyName;
	private String modelNo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getHardDiskSize() {
		return hardDiskSize;
	}
	public void setHardDiskSize(int hardDiskSize) {
		this.hardDiskSize = hardDiskSize;
	}
	public String getGPUName() {
		return GPUName;
	}
	public void setGPUName(String gPUName) {
		GPUName = gPUName;
	}
	private int ram;
	private int hardDiskSize;
	private String GPUName;
}
