package com.java.eshop.web.controller;


import java.nio.file.attribute.UserPrincipalLookupService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.eshop.commons.ServiceResponse;
import com.java.eshop.web.model.para.LoginMessege;
import com.java.eshop.web.model.po.EshopUser;
import com.java.eshop.web.service.EshopUserService;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	EshopUserService userService = new EshopUserService(); 
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	@ResponseBody
	public  ServiceResponse login(@RequestBody LoginMessege msg){
		logger.info(msg.toString());
		ServiceResponse sr = new ServiceResponse();
		userService.login(msg, sr);
		return sr;
	}
}

