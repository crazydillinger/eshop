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
	private BigDecimal payFee;//实付金额
	private Integer reserve;//库存
	private BigDecimal weight;//重量
	private String vender;//厂家
	private String goodsArea;//产地
	private Integer isRecomm;//实否推荐
	private Integer isHot;//是否热卖
	private Integer isNew;//实否新品
	private String describe;//详细描述
	private String picture;//照片
	private Integer isGrounding;//是否上架
	private String username;//录入人
	private Integer lookCount;//查看次数
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
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public String getVender() {
		return vender;
	}
	public void setVender(String vender) {
		this.vender = vender;
	}
	public String getGoodsArea() {
		return goodsArea;
	}
	public void setGoodsArea(String goodsArea) {
		this.goodsArea = goodsArea;
	}
	public Integer getIsRecomm() {
		return isRecomm;
	}
	public void setIsRecomm(Integer isRecomm) {
		this.isRecomm = isRecomm;
	}
	public Integer getIsHot() {
		return isHot;
	}
	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
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
	public Integer getIsGrounding() {
		return isGrounding;
	}
	public void setIsGrounding(Integer isGrounding) {
		this.isGrounding = isGrounding;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getLookCount() {
		return lookCount;
	}
	public void setLookCount(Integer lookCount) {
		this.lookCount = lookCount;
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
		
}
