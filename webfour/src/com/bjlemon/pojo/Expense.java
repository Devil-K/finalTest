package com.bjlemon.pojo;

import java.util.Date;

public class Expense {

	private Integer expenseId;
	private Integer userId;
	private String expenseName;
	private String expenseDesc;
	private Double expenseToltel;
	private Date expenseDate;
	private String expenseState;
	private String expenseMark;
	
	private Integer[]  costIds;//为了接受参数方便
	private String[] detailDescs;
	private Double[] detailMoneys;
	
	private String startDate;
	private String endDate;
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getExpenseName() {
		return expenseName;
	}
	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}
	public String getExpenseDesc() {
		return expenseDesc;
	}
	public void setExpenseDesc(String expenseDesc) {
		this.expenseDesc = expenseDesc;
	}
	public Double getExpenseToltel() {
		return expenseToltel;
	}
	public void setExpenseToltel(Double expenseToltel) {
		this.expenseToltel = expenseToltel;
	}
	public Date getExpenseDate() {
		return expenseDate;
	}
	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}
	public String getExpenseState() {
		return expenseState;
	}
	public void setExpenseState(String expenseState) {
		this.expenseState = expenseState;
	}
	public String getExpenseMark() {
		return expenseMark;
	}
	public void setExpenseMark(String expenseMark) {
		this.expenseMark = expenseMark;
	}
	public Integer[] getCostIds() {
		return costIds;
	}
	public void setCostIds(Integer[] costIds) {
		this.costIds = costIds;
	}
	public String[] getDetailDescs() {
		return detailDescs;
	}
	public void setDetailDescs(String[] detailDescs) {
		this.detailDescs = detailDescs;
	}
	public Double[] getDetailMoneys() {
		return detailMoneys;
	}
	public void setDetailMoneys(Double[] detailMoneys) {
		this.detailMoneys = detailMoneys;
	}
	@Override
	public String toString() {
		return "Expense [expenseId=" + expenseId + ", userId=" + userId + ", expenseName=" + expenseName
				+ ", expenseDesc=" + expenseDesc + ", expenseToltel=" + expenseToltel + ", expenseDate=" + expenseDate
				+ ", expenseState=" + expenseState + ", expenseMark=" + expenseMark + ", costIds=" + costIds
				+ ", detailDescs=" + detailDescs + ", detailMoneys=" + detailMoneys + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", userName=" + userName + "]";
	}
	 
	
	
	
	
}
