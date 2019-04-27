package com.bjlemon.pojo;

public class Menus {
	private Integer menuId;
	private String menuName;
	private Integer pMenuId;
	private String menuUrl;
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public Integer getpMenuId() {
		return pMenuId;
	}
	public void setpMenuId(Integer pMenuId) {
		this.pMenuId = pMenuId;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	@Override
	public String toString() {
		return "Menus [menuId=" + menuId + ", menuName=" + menuName + ", pMenuId=" + pMenuId + ", menuUrl=" + menuUrl
				+ "]";
	}

}
