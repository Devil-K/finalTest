package com.bjlemon.pojo;

import java.util.Date;

public class AuditRecend {

	private Integer auditId;
	private Integer expenseId;
	private Integer userId;
	private String auditState;
	private String auditSugg;
	private Date auditDate;
	
	private String userName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getAuditId() {
		return auditId;
	}
	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}
	public Integer getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(Integer expenseId) {
		this.expenseId = expenseId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getAuditState() {
		return auditState;
	}
	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}
	public String getAuditSugg() {
		return auditSugg;
	}
	public void setAuditSugg(String auditSugg) {
		this.auditSugg = auditSugg;
	}
	public Date getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}
	@Override
	public String toString() {
		return "AuditRecend [auditId=" + auditId + ", expenseId=" + expenseId + ", userId=" + userId + ", auditState="
				+ auditState + ", auditSugg=" + auditSugg + ", auditDate=" + auditDate + ", userName=" + userName + "]";
	}
	
	
}
