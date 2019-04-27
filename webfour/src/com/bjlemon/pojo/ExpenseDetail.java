package com.bjlemon.pojo;

public class ExpenseDetail {
private  Integer detailId;
private Integer expenseId;
private Integer costId;
private String detailDesc;
private Double detailMoney;
private Integer detailMark;

private String costName;


public String getCostName() {
	return costName;
}
public void setCostName(String costName) {
	this.costName = costName;
}
public Integer getDetailId() {
	return detailId;
}
public void setDetailId(Integer detailId) {
	this.detailId = detailId;
}
public Integer getExpenseId() {
	return expenseId;
}
public void setExpenseId(Integer expenseId) {
	this.expenseId = expenseId;
}
public Integer getCostId() {
	return costId;
}
public void setCostId(Integer costId) {
	this.costId = costId;
}
public String getDetailDesc() {
	return detailDesc;
}
public void setDetailDesc(String detailDesc) {
	this.detailDesc = detailDesc;
}
public Double getDetailMoney() {
	return detailMoney;
}
public void setDetailMoney(Double detailMoney) {
	this.detailMoney = detailMoney;
}
public Integer getDetailMark() {
	return detailMark;
}
public void setDetailMark(Integer detailMark) {
	this.detailMark = detailMark;
}
@Override
public String toString() {
	return "ExpenseDetail [detailId=" + detailId + ", expenseId=" + expenseId + ", costId=" + costId + ", detailDesc="
			+ detailDesc + ", detailMoney=" + detailMoney + ", detailMark=" + detailMark + ", costName=" + costName
			+ "]";
}


}
