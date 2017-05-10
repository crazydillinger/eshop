package com.java.eshop.web.model.po;

import java.util.Date;

public class EshopUser {
	
	private Long id;
	private String username;
	private String realName;
	private String password;
	private String userTel;
	private String userMail;
	private String photo;
	private Long integral;
	private String question;
	private String answer;
	private String gender;
	private String province;
	private String city;
	private Integer valid;
	private Date addTime;
	private Date updTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Long getIntegral() {
		return integral;
	}
	public void setIntegral(Long integral) {
		this.integral = integral;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getValid() {
		return valid;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
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
		return "EshopUser [id=" + id + ", username=" + username + ", realName=" + realName + ", password=" + password
				+ ", userTel=" + userTel + ", userMail=" + userMail + ", photo=" + photo + ", integral=" + integral
				+ ", question=" + question + ", answer=" + answer + ", gender=" + gender + ", province=" + province
				+ ", city=" + city + ", valid=" + valid + ", addTime=" + addTime + ", updTime=" + updTime + "]";
	}
	
	
}
