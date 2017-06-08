package com.java.eshop.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.java.eshop.web.dao.impl.EshopAddressDAOImpl;
import com.java.eshop.web.model.para.AddressMsg;
import com.java.eshop.web.model.po.EshopAddress;
import com.java.eshop.web.model.po.EshopUser;

@Controller
@RequestMapping("/eshopAddress")
public class AddressController {
	
	private static final Logger logger = LoggerFactory.getLogger(AddressController.class);  
	
	private EshopAddressDAOImpl addressDaoImpl = new EshopAddressDAOImpl();
	
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ServiceResponse address(@RequestBody AddressMsg msg,HttpServletRequest request){
		ServiceResponse sr = new ServiceResponse();
		EshopUser user = (EshopUser) request.getSession().getAttribute("USER");
		if(null == user){
			sr.error("msg","请先登录");
			return sr;
		}
		EshopAddress address = new EshopAddress();
		address.setUserTel(msg.getUserTel());		
		address.setUsername(msg.getUsername());
		address.setZipCode(msg.getZipcode());
		address.setProvince(msg.getProvince());
		address.setCity(msg.getCity());
		address.setCounty(msg.getCounty());
		address.setDetailAddress(msg.getDetailaddress());
		address.setDefaultAddress(-1);
		address.setUserId(user.getId());
		try {
			addressDaoImpl.insert(address);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sr.put("msg","添加地址成功");
		return sr;
	}
	
	@ResponseBody
	@RequestMapping(value="/all",method=RequestMethod.POST)
	public ServiceResponse all(HttpServletRequest request){
		ServiceResponse sr = new ServiceResponse();
		EshopUser user = (EshopUser) request.getSession().getAttribute("USER");	
		if(null == user){
			sr.error("msg","请先登录");
			return sr;
		}
		try {
			List<EshopAddress> dbs = addressDaoImpl.selectByUserId(user.getId());
			sr.put("address",dbs);
			logger.info(dbs.toString());
			return sr;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public ServiceResponse delete(@RequestParam Long id){
		ServiceResponse sr = new ServiceResponse();
		try {
			addressDaoImpl.deleteByPrimaryKey(id);
			sr.put("msg","删除成功");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@ResponseBody
	@RequestMapping(value="/one",method=RequestMethod.POST)
	public ServiceResponse one(@RequestParam Long id){
		ServiceResponse sr = new ServiceResponse();
		try {
			EshopAddress address = addressDaoImpl.selectByPrimaryKey(id);
			sr.put("address",address);
			return sr;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sr;
	}
	@ResponseBody
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public ServiceResponse modify(@RequestBody AddressMsg msg,HttpServletRequest request){
		ServiceResponse sr = new ServiceResponse();
		EshopUser user = (EshopUser) request.getSession().getAttribute("USER");
		try {		
			EshopAddress address = addressDaoImpl.selectByPrimaryKey(msg.getId());
 			address.setId(msg.getId());
			address.setUserTel(msg.getUserTel());
			address.setUsername(msg.getUsername());
			address.setZipCode(msg.getZipcode());
			address.setProvince(msg.getProvince());
			address.setCity(msg.getCity());
			address.setCounty(msg.getCounty());
			address.setDetailAddress(msg.getDetailaddress());
			addressDaoImpl.updateByPrimaryKey(address);
			sr.put("msg","更新成功");
			return sr;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sr;
	}
	@ResponseBody
	@RequestMapping(value="/def",method=RequestMethod.POST)
	public ServiceResponse def(@RequestParam Long id,HttpServletRequest request){
		ServiceResponse sr = new ServiceResponse();
		EshopUser user = (EshopUser) request.getSession().getAttribute("USER");
		try {		
			List<EshopAddress> dbs = addressDaoImpl.selectByUserId(user.getId());
			for(EshopAddress obj : dbs){
				if(obj.getDefaultAddress() == 1){
					obj.setDefaultAddress(-1);
					addressDaoImpl.updateByPrimaryKey(obj);
				}
			}
			EshopAddress address = addressDaoImpl.selectByPrimaryKey(id);
			address.setDefaultAddress(1);
			addressDaoImpl.updateByPrimaryKey(address);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sr;
	}
}
