package com.java.eshop.web.service;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;

import com.java.eshop.commons.ServiceResponse;
import com.java.eshop.web.dao.impl.EshopUserDAOImpl;
import com.java.eshop.web.model.para.LoginMessege;
import com.java.eshop.web.model.po.EshopUser;

public class EshopUserService {
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(EshopUserService.class);
	
	EshopUserDAOImpl userDAOImpl = new EshopUserDAOImpl();
	
	public void login(LoginMessege user,ServiceResponse sr){
		//权限设置
		//session
		if(null == user.getUsername()){
			sr.error("msg", "用户名不能为空");
			return;
		}
		if(null == user.getPassword()){
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
	}
}
