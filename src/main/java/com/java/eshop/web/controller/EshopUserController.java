package com.java.eshop.web.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.eshop.commons.ServiceResponse;
import com.java.eshop.web.model.para.LoginMessege;
import com.java.eshop.web.model.para.RegisterMsg;
import com.java.eshop.web.model.po.EshopUser;
import com.java.eshop.web.service.EshopUserService;
import com.sun.org.apache.bcel.internal.generic.ReturnInstruction;
@RequestMapping(value = "/user")
@Controller
public class EshopUserController {
	
	private static final Logger logger = LoggerFactory.getLogger(EshopUserController.class);
	
	EshopUserService userService = new EshopUserService(); 
	/**
	 * 用户登录
	 * @param msg
	 * @return
	 */
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	@ResponseBody
	public  ServiceResponse login(@RequestBody LoginMessege msg){
		logger.info(msg.toString());
		ServiceResponse sr = new ServiceResponse();
		userService.login(msg, sr);
		return sr;
	}
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	@ResponseBody
	public ServiceResponse register(@RequestBody RegisterMsg registerMsg){
		ServiceResponse sr = new ServiceResponse();
		userService.register(sr, registerMsg);
		return sr;
	}	
}

