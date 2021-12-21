package com.devpro.shop15.dto;

public class ProductSearchModel {
	//tim theo keyword
public String keyword;

//tim theo cate
public Integer categoryId;
public Boolean status;
public Boolean isHot;
public String seo;
//page hien tai
public int page;

public Boolean getStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}
public String getKeyword() {
	return keyword;
}
public void setKeyword(String keyword) {
	this.keyword = keyword;
}
public Integer getCategoryId() {
	return categoryId;
}
public void setCategoryId(Integer categoryId) {
	this.categoryId = categoryId;
}
public boolean isHot() {
	return isHot;
}
public void setHot(boolean isHot) {
	this.isHot = isHot;
}
public String getSeo() {
	return seo;
}
public void setSeo(String seo) {
	this.seo = seo;
}
public int getPage() {
	return page;
}
public void setPage(int page) {
	this.page = page;
}



}
