package com.super_shop.dto;

import java.util.Date;

import com.super_shop.entity.Customer;
import com.super_shop.entity.Sales;

public class BillDTO {
	
	private Long billId;

	private Customer customer;
	
	private String custBillId;
	
	private Long payableAmount;
	
	private Long discountAmount;
	
	private Long netPayment;
	
	private Long due;
	
	private Date createDate;
	
	private String date;

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCustBillId() {
		return custBillId;
	}

	public void setCustBillId(String custBillId) {
		this.custBillId = custBillId;
	}

	public Long getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(Long payableAmount) {
		this.payableAmount = payableAmount;
	}

	public Long getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Long discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Long getNetPayment() {
		return netPayment;
	}

	public void setNetPayment(Long netPayment) {
		this.netPayment = netPayment;
	}

	public Long getDue() {
		return due;
	}

	public void setDue(Long due) {
		this.due = due;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	

}
