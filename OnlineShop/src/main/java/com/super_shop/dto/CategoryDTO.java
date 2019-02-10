package com.super_shop.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class CategoryDTO {

	private Long cateId;

	private String cateName;

	private String createBy;

	private Date createDate;
	
	private MultipartFile photos;

	public CategoryDTO() {
		super();
	}

	public Long getCateId() {
		return cateId;
	}

	public void setCateId(Long cateId) {
		this.cateId = cateId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
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

	public MultipartFile getPhotos() {
		return photos;
	}

	public void setPhotos(MultipartFile photos) {
		this.photos = photos;
	}

	
	

}
