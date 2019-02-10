package com.super_shop.dto;

public class PassResetDTO {
	
	private Long resetID;
	
	private String userName;
	
	private String password;
	
	private String newPassword;

	public PassResetDTO() {
		super();
	}

	public Long getResetID() {
		return resetID;
	}

	public void setResetID(Long resetID) {
		this.resetID = resetID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	

}
