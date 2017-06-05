package com.java.eshop.web.model.po;

import java.math.BigDecimal;
import java.sql.Date;

import com.sun.jmx.snmp.Timestamp;

public class EshopGoods {
	private Long id;//id
	private Long categoryId;//类别id
	private String goodsName;//商品名
	private BigDecimal sellPrice;//售价
	private BigDecimal primePrice;//原价
	private Integer promotionType;//优惠类型
	private BigDecimal promotionValue;//优惠值
	private String type;//类型
	private BigDecimal payFee;//实付金额
	private Integer reserve;//库存
	private Integer isNew;//实否新品
	private String describe;//详细描述
	private String picture;//照片
	private Integer integral;//商品积分
	private Date addTime;
	private Date updTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public BigDecimal getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}
	public BigDecimal getPrimePrice() {
		return primePrice;
	}
	public void setPrimePrice(BigDecimal primePrice) {
		this.primePrice = primePrice;
	}
	public Integer getPromotionType() {
		return promotionType;
	}
	public void setPromotionType(Integer promotionType) {
		this.promotionType = promotionType;
	}
	public BigDecimal getPromotionValue() {
		return promotionValue;
	}
	public void setPromotionValue(BigDecimal promotionValue) {
		this.promotionValue = promotionValue;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getPayFee() {
		return payFee;
	}
	public void setPayFee(BigDecimal payFee) {
		this.payFee = payFee;
	}
	public Integer getReserve() {
		return reserve;
	}
	public void setReserve(Integer reserve) {
		this.reserve = reserve;
	}
	public Integer getIsNew() {
		return isNew;
	}
	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Integer getIntegral() {
		return integral;
	}
	public void setIntegral(Integer integral) {
		this.integral = integral;
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
	@Override
	public String toString() {
		return "EshopGoods [id=" + id + ", categoryId=" + categoryId + ", goodsName=" + goodsName + ", sellPrice="
				+ sellPrice + ", primePrice=" + primePrice + ", promotionType=" + promotionType + ", promotionValue="
				+ promotionValue + ", type=" + type + ", payFee=" + payFee + ", reserve=" + reserve + ", isNew=" + isNew
				+ ", describe=" + describe + ", picture=" + picture + ", integral=" + integral + ", addTime=" + addTime
				+ ", updTime=" + updTime + "]";
	}
	
	
}
