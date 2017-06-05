package com.java.eshop.web.model.po;

public class EshopCategory {
	private Long id;
	private Integer rank;
	private Long parentId;
	private String categoryName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "EshopCategory [id=" + id + ", rank=" + rank + ", parentId=" + parentId + ", categoryName="
				+ categoryName + "]";
	}
	
	
}
