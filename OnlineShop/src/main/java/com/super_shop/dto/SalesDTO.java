package com.super_shop.dto;

import com.super_shop.entity.Bill;
import com.super_shop.entity.Customer;
import com.super_shop.entity.Price;
import com.super_shop.entity.Product;

public class SalesDTO {
	
	private Long saleId;
	
	private Price price;
	
	private String productName;
	
	private Integer purchase_price; 
	
	private Float totualPrice;
	
	private Integer quantity;
	
	private Customer customer;
	
	private Bill bill;
	
	private Double individual_profit;
	
	private String date;;


	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Customer getCustomer() {
		if(customer==null) customer=new Customer();
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getSaleId() {
		return saleId;
	}

	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	

	public Integer getPurchase_price() {
		return purchase_price;
	}

	public void setPurchase_price(Integer purchase_price) {
		this.purchase_price = purchase_price;
	}

	public Float getTotualPrice() {
		return totualPrice;
	}

	public void setTotualPrice(Float totualPrice) {
		this.totualPrice = totualPrice;
	}

	public Price getPrice() {
		if(price==null) price=new Price();
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Bill getBill() {
		if(bill==null) bill=new Bill();
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Double getIndividual_profit() {
		return individual_profit;
	}

	public void setIndividual_profit(Double individual_profit) {
		this.individual_profit = individual_profit;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	

}
