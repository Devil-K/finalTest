package com.bjlemon.pojo;

public class User {
	
	private String ck;
	
	private Integer userId;
	
	private Integer roleId;
	
	private String userName;
	
	private String userSex;
	
	private Integer userAge;
	
	private String  userPhone;
	
	private String userAccount;
	
	private String userPwd;
	
	private Double userSalary;
	
	private Integer userMark;

	private String roleName;
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCk() {
		return "<input type='checkbox' name='ids' value='"+this.userId+"'>";
	}

	public void setCk(String ck) {
		this.ck = ck;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Double getUserSalary() {
		return userSalary;
	}

	public void setUserSalary(Double userSalary) {
		this.userSalary = userSalary;
	}

	public Integer getUserMark() {
		return userMark;
	}

	public void setUserMark(Integer userMark) {
		this.userMark = userMark;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", roleId=" + roleId + ", userName=" + userName + ", userSex=" + userSex
				+ ", userAge=" + userAge + ", userPhone=" + userPhone + ", userAccount=" + userAccount + ", userPwd="
				+ userPwd + ", userSalary=" + userSalary + ", userMark=" + userMark + "]";
	}
	
}
