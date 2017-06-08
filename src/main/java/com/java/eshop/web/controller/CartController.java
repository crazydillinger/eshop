package com.java.eshop.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.eshop.commons.ServiceResponse;
import com.java.eshop.web.dao.EshopCartItemDAO;
import com.java.eshop.web.dao.impl.EshopCartDAOImpl;
import com.java.eshop.web.dao.impl.EshopCartItemDAOImpl;
import com.java.eshop.web.dao.impl.EshopGoodsDAOImpl;
import com.java.eshop.web.model.para.CartMsg;
import com.java.eshop.web.model.po.EshopCart;
import com.java.eshop.web.model.po.EshopCartItem;
import com.java.eshop.web.model.po.EshopGoods;
import com.java.eshop.web.model.po.EshopUser;

@Controller
@RequestMapping(value = "/shopCart")
public class CartController {

	private EshopCartDAOImpl cartDAOImpl = new EshopCartDAOImpl();

	private EshopCartItemDAOImpl cartItemDAOImpl = new EshopCartItemDAOImpl();
	
	private EshopGoodsDAOImpl goodsDAOImpl = new EshopGoodsDAOImpl();

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ServiceResponse add(@RequestBody CartMsg msg, HttpServletRequest request) throws IOException {
		ServiceResponse sr = new ServiceResponse();
		EshopUser user = (EshopUser) request.getSession().getAttribute("USER");
		EshopCart cart = cartDAOImpl.selectByUserId(user.getId());
		EshopCartItem item = null;
		try {
			item = cartItemDAOImpl.selectByProductId(msg.getId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null == item) {
			EshopCartItem i = new EshopCartItem();
			i.setCartId(cart.getId());
			i.setNumber(new Long(msg.getNumber()));
			i.setProductId(msg.getId());
			cartItemDAOImpl.insert(i);
		} else {
			item.setNumber(item.getNumber() + msg.getNumber());
			cartItemDAOImpl.updateByPrimaryKey(item);
		}
		return sr;
	}

	@ResponseBody
	@RequestMapping(value = "/all", method = RequestMethod.POST)
	public ServiceResponse all(HttpServletRequest request) throws IOException {
		ServiceResponse sr = new ServiceResponse();
		EshopUser user = (EshopUser) request.getSession().getAttribute("USER");
		EshopCart cart = cartDAOImpl.selectByUserId(user.getId());
		List<EshopCartItem> items = cartItemDAOImpl.selectByCartId(cart.getId());
		if(null == items){
			return sr;
		}
		List<EshopGoods> lists = new ArrayList<EshopGoods>();
		for(EshopCartItem item : items){
			EshopGoods goods = goodsDAOImpl.selectByPrimaryKey(item.getProductId());
			goods.setIsNew(item.getNumber().intValue());
			lists.add(goods);
;		}
		sr.put("lists",lists);
		return sr;
	}
}
