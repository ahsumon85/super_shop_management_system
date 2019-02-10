package com.super_shop.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.super_shop.entity.Category;


public class ProductDTO {
	
	private Long itemId;
	
	private String itemName;
	
	private String itemCode;
	
	private String itemBrand;
	
	private Category category;
	
	private String itemAbout;
	
	private String createBy;
	
	private Date createDate;
	
	private Date editDate;
	
	private String itemImage;
	
	private Integer isValid;

	private MultipartFile photos;
	
	
	public ProductDTO() {
		super();
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemBrand() {
		return itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}


	public String getItemAbout() {
		return itemAbout;
	}

	public void setItemAbout(String itemAbout) {
		this.itemAbout = itemAbout;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	public MultipartFile getPhotos() {
		return photos;
	}

	public void setPhotos(MultipartFile photos) {
		this.photos = photos;
	}


	public Category getCategory() {
		if(category==null) category=new Category();
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

}