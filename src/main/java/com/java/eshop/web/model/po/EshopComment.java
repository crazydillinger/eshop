package com.java.eshop.web.model.po;

import java.util.Date;

public class EshopComment {
	private Long id;
	private String title;
	private String comment;
	private Integer grade;
	private Long userId;
	private Long productId;
	private Date addTime;
	private Date updTime;
	
	public EshopComment(Long id, String title, String comment, Integer grade, Long userId, Long productId, Date addTime,
			Date updTime) {
		super();
		this.id = id;
		this.title = title;
		this.comment = comment;
		this.grade = grade;
		this.userId = userId;
		this.productId = productId;
		this.addTime = addTime;
		this.updTime = updTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Date getUpdTime() {
		return updTime;
	}
	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}
	
}
