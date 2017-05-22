package com.java.eshop.web.service;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.http.HttpRequest;

import com.java.eshop.commons.ServiceResponse;
import com.java.eshop.web.dao.impl.EshopUserDAOImpl;
import com.java.eshop.web.model.para.LoginMessege;
import com.java.eshop.web.model.para.RegisterMsg;
import com.java.eshop.web.model.po.EshopUser;

public class EshopUserService {
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(EshopUserService.class);
	
	EshopUserDAOImpl userDAOImpl = new EshopUserDAOImpl();
	
	public void login(LoginMessege user,ServiceResponse sr,HttpServletRequest request){
		//权限设置
		//session
		if(StringUtils.isBlank(user.getUsername())){
			sr.error("msg", "用户名不能为空");
			return;
		}
		if(StringUtils.isBlank(user.getPassword())){
			sr.error("msg","密码不能为空");
			return;
		}
		EshopUser u = null;
		try {
			u =  userDAOImpl.selectByUsername(user.getUsername());
		} catch (IOException e) {
			logger.info(e.getMessage());
		} finally {
			if(null == u){
				sr.error("msg", "用户名或密码错误!");
				return;
			}
		}
		if(!user.getPassword().equals(u.getPassword())){
			sr.error("msg", "用户名或密码错误!");
			return;
		}
		sr.put("msg", "登陆成功！");
		request.getSession().setAttribute("USER", u);
	}
	
	/**
	 * 用户注册
	 * @param sr
	 * @param registerMsg
	 */
	public void register(ServiceResponse sr,RegisterMsg registerMsg){
		boolean isCheck = checkRegMsg(sr, registerMsg);
		if(!isCheck){
			return;
		}
		try {
			EshopUser user = userDAOImpl.selectByUsername(registerMsg.getUsername());
			if(null != user){
				sr.error("msg", "该用户已存在");
				return;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EshopUser u = new EshopUser();
		u.setUsername(registerMsg.getUsername());
		u.setPassword(registerMsg.getPassword());
		u.setAddTime(new Date());
		u.setValid(0);
		try {
			userDAOImpl.insert(u);
			sr.put("msg", "注册成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean checkRegMsg(ServiceResponse sr,RegisterMsg registerMsg) {
		if(StringUtils.isBlank(registerMsg.getUsername())){
			sr.error("msg", "用户名不能为空");
			return false;
		}
		if(StringUtils.isBlank(registerMsg.getPassword())){
			sr.error("msg", "密码不能为空");
			return false;
		}
		if(StringUtils.isBlank(registerMsg.getPwdRepeat())){
			sr.error("msg", "请确认密码");
			return false;
		}
		if(!registerMsg.getPassword().equals(registerMsg.getPwdRepeat())){
			sr.error("msg", "两次密码不一样");
			return false;
		}
		return true;
	}
	
}
