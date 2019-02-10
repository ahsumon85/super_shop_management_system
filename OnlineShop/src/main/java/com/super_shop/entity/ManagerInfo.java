package com.super_shop.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="managerInfo")
public class ManagerInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="manager_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long managerId;
	
	@Column(name="manager_name")
	private String managerName;
	
	@Column(name="national_id")
	private String nationalId;
	
	
	@Column(name="number")
	private String number;
	
	@Column(name="create_date")
	private Date createDate;

	
	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
		

}
