package com.bjlemon.pojo;

import java.util.Date;

public class Salary {

	private Integer salaryId;
	private Integer userId;
	private Date salaryMonth;
	private Date salaryDate;
	private Double salaryBasic;
	private Double salaryComm;
	private String userName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getSalaryId() {
		return salaryId;
	}
	public void setSalaryId(Integer salaryId) {
		this.salaryId = salaryId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getSalaryMonth() {
		return salaryMonth;
	}
	public void setSalaryMonth(Date salaryMonth) {
		this.salaryMonth = salaryMonth;
	}
	public Date getSalaryDate() {
		return salaryDate;
	}
	public void setSalaryDate(Date salaryDate) {
		this.salaryDate = salaryDate;
	}
	public Double getSalaryBasic() {
		return salaryBasic;
	}
	public void setSalaryBasic(Double salaryBasic) {
		this.salaryBasic = salaryBasic;
	}
	public Double getSalaryComm() {
		return salaryComm;
	}
	public void setSalaryComm(Double salaryComm) {
		this.salaryComm = salaryComm;
	}
	@Override
	public String toString() {
		return "Salary [salaryId=" + salaryId + ", userId=" + userId + ", salaryMonth=" + salaryMonth + ", salaryDate="
				+ salaryDate + ", salaryBasic=" + salaryBasic + ", salaryComm=" + salaryComm + ", userName=" + userName
				+ "]";
	}
	 
	
}
