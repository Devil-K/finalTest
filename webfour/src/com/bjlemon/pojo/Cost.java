package com.bjlemon.pojo;

public class Cost {
	private String ck;
	private Integer costId;
	private String costName;
	private String costDesc;
	private String costMark;
	
	public String getCk() {
		return "<input type='checkbox' name='ids' value='"+this.costId+"'>";
	}
	public void setCk(String ck) {
		this.ck = ck;
	}
	public Integer getCostId() {
		return costId;
	}
	public void setCostId(Integer costId) {
		this.costId = costId;
	}
	public String getCostName() {
		return costName;
	}
	public void setCostName(String costName) {
		this.costName = costName;
	}
	public String getCostDesc() {
		return costDesc;
	}
	public void setCostDesc(String costDesc) {
		this.costDesc = costDesc;
	}
	public String getCostMark() {
		return costMark;
	}
	public void setCostMark(String costMark) {
		this.costMark = costMark;
	}
	@Override
	public String toString() {
		return "cost [costId=" + costId + ", costName=" + costName + ", costDesc=" + costDesc + ", costMark=" + costMark
				+ "]";
	}
	

}
