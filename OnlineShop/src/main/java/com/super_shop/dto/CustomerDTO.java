package com.super_shop.dto;

public class CustomerDTO {
	
	private Long customerid;
	
	private String customerName;
	
	private String phoneNumber;
	
	private String customerType;
	
	private String customesEmail;
	
	private String customerAddress;
	
	private String customerNotes;
	
	private String customerBillId;


	public CustomerDTO() {
		super();
	}

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
