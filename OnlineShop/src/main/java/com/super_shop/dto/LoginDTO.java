package com.super_shop.dto;
import com.super_shop.entity.ManagerInfo;

public class LoginDTO {
	
	private Long loginId;
	
	private String userName;
	
	private String password;
	
	private int role;
	
	private ManagerInfo managerInfo;

	public LoginDTO() {
		super();
	}

	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}


	public ManagerInfo getManagerInfo() {
		if(managerInfo==null) managerInfo=new ManagerInfo();
		return managerInfo;
	}

	public void setManagerInfo(ManagerInfo managerInfo) {
		this.managerInfo = managerInfo;
	}
	
	

}
