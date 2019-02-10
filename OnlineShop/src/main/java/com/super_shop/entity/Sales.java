package com.super_shop.entity;

import java.io.Serializable;

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
@Table(name="sales")
public class Sales implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sale_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long saleId;
	
	@ManyToOne/*(fetch=FetchType.LAZY)*/
	@JoinColumn(name="price_id")
	private Price price;
	
	@ManyToOne/*(fetch=FetchType.LAZY)*/
	@JoinColumn(name="bill_id")
	private Bill bill;
	
	@Column(name="quantity")
	private Integer quantity;

	/*@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="custome_id")
	private Customer customer;*/
	
	
	public Long getSaleId() {
		return saleId;
	}

	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}


	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/*public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
*/
	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
	

}
