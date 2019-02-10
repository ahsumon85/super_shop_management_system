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

import org.springframework.data.solr.core.mapping.Indexed;

@Entity
@Table(name="productPrice")
public class Price implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="price_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long priceId;

	@ManyToOne/*(fetch=FetchType.LAZY)*/
	@JoinColumn(name="itemId")
	private Product product;

	@Column(name="product_size")
	private String productSize;

	@Column(name="retails_price")
	private Integer retails_price;
	
	@Column(name="purchase_price")
	private Integer purchase_price;
	
	@Column(name="bar_code")
	private String bar_code;

	@Column(name="create_date")
	private Date create_date;

	@Column(name="item_quantity")
	private Integer item_quantity;

	public Long getPriceId() {
		return priceId;
	}

	public void setPriceId(Long priceId) {
		this.priceId = priceId;
	}

	public Product getProduct() {
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

	public Integer getPurchase_price() {
		return purchase_price;
	}

	public void setPurchase_price(Integer purchase_price) {
		this.purchase_price = purchase_price;
	}
	


}
