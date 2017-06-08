package com.java.eshop.web.controller;

import java.io.IOException;
import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.eshop.commons.ServiceResponse;
import com.java.eshop.web.dao.impl.EshopFavoriteDAOImpl;
import com.java.eshop.web.dao.impl.EshopGoodsDAOImpl;
import com.java.eshop.web.model.po.EshopFavorite;
import com.java.eshop.web.model.po.EshopGoods;
import com.java.eshop.web.model.po.EshopUser;

@Controller
@RequestMapping(value="/collection")
public class FavoriteController {
	
	private EshopGoodsDAOImpl goodsDAOImpl = new EshopGoodsDAOImpl();
	
	private EshopFavoriteDAOImpl favoriteDAOImpl = new EshopFavoriteDAOImpl(); 
	
	@ResponseBody
	@RequestMapping(value="/one", method = RequestMethod.POST)
	public ServiceResponse one(HttpServletRequest request,@RequestParam Long id){
		ServiceResponse sr = new ServiceResponse();
		EshopUser user = (EshopUser) request.getSession().getAttribute("USER");
		//默认每次收藏不重复
		EshopFavorite f = new EshopFavorite();
		f.setAddTime(new Date());
		f.setProductId(id);
		f.setUserId(user.getId());
		try {
			favoriteDAOImpl.insert(f);
			sr.put("msg","收藏成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value="/all", method = RequestMethod.POST)
	public ServiceResponse all(HttpServletRequest request){
		ServiceResponse sr = new ServiceResponse();
		EshopUser user = (EshopUser) request.getSession().getAttribute("USER");
		List<EshopGoods> goods = new ArrayList<EshopGoods>();
		List<EshopFavorite> dbs = null;
		try {
			dbs = favoriteDAOImpl.selectByUserId(user.getId());
			if(dbs == null || dbs.size() == 0){
				return sr;
			}else{
				for(EshopFavorite i : dbs){
					EshopGoods f = goodsDAOImpl.selectByPrimaryKey(i.getProductId());
					goods.add(f);
				}
				sr.put("goods",goods);
				return sr;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
