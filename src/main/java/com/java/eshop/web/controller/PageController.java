package com.java.eshop.web.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author chengkui
 *
 */
@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@RequestMapping(value = "/ms/login", method = RequestMethod.GET)
	public String loginPage(Locale locale, Model model) {
		logger.info("进入登陆页", locale);
		return "admin-ui/login";
	}
	
	@RequestMapping(value = "/ms/index",method = RequestMethod.GET)
	public String msIndex(Locale locale, Model model) {
		return "admin-ui/index";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "eshop-ui/home/login";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		return "eshop-ui/home/index";
	}
	
	@RequestMapping(value="/register",method= RequestMethod.GET)
	public String register(){
		return "eshop-ui/home/register";
	}
}
