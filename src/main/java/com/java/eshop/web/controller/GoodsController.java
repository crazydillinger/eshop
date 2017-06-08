package com.java.eshop.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.eshop.commons.ServiceResponse;
import com.java.eshop.web.dao.impl.EshopGoodsDAOImpl;
import com.java.eshop.web.model.po.EshopGoods;

@Controller
@RequestMapping(value="/goods")
public class GoodsController {
	
	private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
	
	private EshopGoodsDAOImpl goodsDAOImpl = new EshopGoodsDAOImpl();
	
	@ResponseBody
	@RequestMapping(value="/all",method = RequestMethod.POST)
	public ServiceResponse all(){
		ServiceResponse sr = new ServiceResponse();
		Map<String, Object> params = new HashMap<String, Object>();
		List<List<EshopGoods>> lists = new ArrayList<List<EshopGoods>>();
		try {
			List<EshopGoods> goods = goodsDAOImpl.selectByParams(params);
			lists.add(goods);
			sr.put("lists",lists);
			return sr;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value="/one",method = RequestMethod.POST)
	public ServiceResponse one(@RequestParam Long id){
		ServiceResponse sr = new ServiceResponse();
		try {
			EshopGoods goods = goodsDAOImpl.selectByPrimaryKey(id);
			logger.info(goods.toString());
			sr.put("goods",goods);
			return sr;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@ResponseBody
	@RequestMapping(value="/like",method = RequestMethod.POST)
	public ServiceResponse like(@RequestParam String goodsName) throws IOException{
		ServiceResponse sr = new ServiceResponse();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("goodsName",goodsName);
		List<EshopGoods> goods = goodsDAOImpl.selectByParams(params);
		if(null == goods || goods.size() == 0){
			sr.put("code","-1");
			return sr;
		}else{
			sr.put("id",goods.get(0).getId());
			return sr;
		}
	}
}
