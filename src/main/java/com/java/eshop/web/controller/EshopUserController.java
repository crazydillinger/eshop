package com.java.eshop.web.controller;



import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.java.eshop.web.dao.impl.EshopUserDAOImpl;
import com.java.eshop.web.model.para.LoginMessege;
import com.java.eshop.web.model.para.ModifyUserMsg;
import com.java.eshop.web.model.para.RegisterMsg;
import com.java.eshop.web.model.po.EshopUser;
import com.java.eshop.web.service.EshopUserService;
import com.sun.org.apache.bcel.internal.generic.ReturnInstruction;
@RequestMapping(value = "/user")
@Controller
public class EshopUserController {
	
	private static final Logger logger = LoggerFactory.getLogger(EshopUserController.class);
	
	EshopUserService userService = new EshopUserService(); 
	EshopUserDAOImpl userDAOImpl = new EshopUserDAOImpl();
	/**
	 * 用户登录
	 * @param msg
	 * @return
	 */
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	@ResponseBody
	public  ServiceResponse login(@RequestBody LoginMessege msg,HttpServletRequest request){
		logger.info(msg.toString());
		ServiceResponse sr = new ServiceResponse();
		userService.login(msg, sr,request);
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
	
	@RequestMapping(value = "/userSession",method = RequestMethod.POST)
	@ResponseBody
	public ServiceResponse userSession(HttpServletRequest request){
		ServiceResponse sr = new ServiceResponse();
		EshopUser user = (EshopUser) request.getSession().getAttribute("USER");
		sr.put("user",user);
		return sr;
	}
	@RequestMapping(value = "/modify",method = RequestMethod.POST)
	@ResponseBody
	public ServiceResponse modifyUser(@RequestBody ModifyUserMsg msg,HttpServletRequest request){
		ServiceResponse sr = new ServiceResponse();
		EshopUser user = (EshopUser) request.getSession().getAttribute("USER");
		if(null == user){
			sr.error("msg", "请先登录");
			return sr;
		}
		user.setRealName(msg.getRealName());
		user.setAnswer(msg.getAnswer());
		user.setGender(msg.getGender());
		user.setQuestion(msg.getQuestion());
		user.setUserMail(msg.getUserMail());
		user.setUserTel(msg.getUserTel());		
		try {
			userDAOImpl.updateByPrimaryKey(user);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sr.put("msg","修改成功");
		return sr;
	}
	@RequestMapping(value = "/loadUserInfo",method = RequestMethod.POST)
	@ResponseBody
	public ServiceResponse loadUserInfo(HttpServletRequest request){
		ServiceResponse sr = new ServiceResponse();
		EshopUser user = (EshopUser) request.getSession().getAttribute("USER");
		if(null == user){
			sr.error("msg", "请先登录");
			return sr;
		}
		sr.put("user",user);
		return sr;
	}
	
}

