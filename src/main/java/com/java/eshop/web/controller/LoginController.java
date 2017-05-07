package com.java.eshop.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.eshop.commons.ServiceResponse;
import com.java.eshop.web.model.para.LoginMessege;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	@ResponseBody
	public  ServiceResponse login(@RequestBody LoginMessege msg){
		logger.info(msg.toString());
		ServiceResponse sr = new ServiceResponse();
		sr.put("user", msg);
		return sr;
	}
}

