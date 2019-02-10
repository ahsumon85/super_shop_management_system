package com.super_shop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="customerid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerid;
	
	@Column(name="customerName")
	private String customerName;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="customerType")
	private String customerType;
	
	@Column(name="customesEmail")
	private String customesEmail;
	
	@Column(name="customerAddress")
	private String customerAddress;
	
	@Column(name="customerNotes")
	private String customerNotes;
	
	@Column(name="customerBillId")
	private String customerBillId;

	public Long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Long customerid) {
		this.customerid = customerid;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getCustomesEmail() {
		return customesEmail;
	}

	public void setCustomesEmail(String customesEmail) {
		this.customesEmail = customesEmail;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerNotes() {
		return customerNotes;
	}

	public void setCustomerNotes(String customerNotes) {
		this.customerNotes = customerNotes;
	}

	public String getCustomerBillId() {
		return customerBillId;
	}

	public void setCustomerBillId(String customerBillId) {
		this.customerBillId = customerBillId;
	}
	
	
	


}
