package com.super_shop.dto;

import java.util.Date;

import com.super_shop.entity.Product;

public class PriceDTO {
	
	private Long priceId;
	
	private Product product;
	
	private String productName;
	
	private String productSize;
	
	private Integer retails_price;
	
	private Integer purchase_price; 
	
	private Integer discount_rate;
	
	private Float total_price;
	
	private String bar_code;
	
	private Date create_date;
	
	private Integer item_quantity;
	
	private String strignQuantity;
	
	private Float total_capital;
	
	private Integer total_profit;
	
	private Integer total_retails;
	
	private Integer individual_profit;

	public PriceDTO() {
		super();
	}

	public Long getPriceId() {
		return priceId;
	}

	public void setPriceId(Long priceId) {
		this.priceId = priceId;
	}

	public Product getProduct() {
		if(product==null) product=new Product();
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public Integer getRetails_price() {
		return retails_price;
	}

	public void setRetails_price(Integer retails_price) {
		this.retails_price = retails_price;
	}

	public Integer getPurchase_price() {
		return purchase_price;
	}

	public void setPurchase_price(Integer purchase_price) {
		this.purchase_price = purchase_price;
	}

	public Integer getDiscount_rate() {
		return discount_rate;
	}

	public void setDiscount_rate(Integer discount_rate) {
		this.discount_rate = discount_rate;
	}

	public String getBar_code() {
		return bar_code;
	}

	public void setBar_code(String bar_code) {
		this.bar_code = bar_code;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Integer getItem_quantity() {
		return item_quantity;
	}

	public void setItem_quantity(Integer item_quantity) {
		this.item_quantity = item_quantity;
	}

	public Float getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Float total_price) {
		this.total_price = total_price;
	}




	public Integer getTotal_profit() {
		return total_profit;
	}

	public void setTotal_profit(Integer total_profit) {
		this.total_profit = total_profit;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Float getTotal_capital() {
		return total_capital;
	}

	public void setTotal_capital(Float total_capital) {
		this.total_capital = total_capital;
	}

	public Integer getTotal_retails() {
		return total_retails;
	}

	public void setTotal_retails(Integer total_retails) {
		this.total_retails = total_retails;
	}

	public Integer getIndividual_profit() {
		return individual_profit;
	}

	public void setIndividual_profit(Integer individual_profit) {
		this.individual_profit = individual_profit;
	}

	public String getStrignQuantity() {
		return strignQuantity;
	}

	public void setStrignQuantity(String strignQuantity) {
		this.strignQuantity = strignQuantity;
	}
	
	

}
