package com.super_shop.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="customerBill")
public class Bill implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="bill_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long billId;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customerid")
	private Customer customer;

	@Column(name="custBillId")
	private String custBillId;

	@Column(name="payableAmount")
	private Long payableAmount;

	@Column(name="discountAmount")
	private Long discountAmount;

	@Column(name="netPayment")
	private Long netPayment;

	@Column(name="due")
	private Long due;

	@Column(name="createDate")
	private Date createDate;

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
	
	

}
