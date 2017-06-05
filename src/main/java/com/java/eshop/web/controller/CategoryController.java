package com.java.eshop.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.junit.runners.ParentRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.eshop.commons.ServiceResponse;
import com.java.eshop.web.dao.impl.EshopCategoryDAOImpl;
import com.java.eshop.web.model.para.CategoryMsg;
import com.java.eshop.web.model.po.EshopCategory;

@RequestMapping(value="/category")
@Controller
public class CategoryController {
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	private EshopCategoryDAOImpl eshopCategoryDAOImpl = new EshopCategoryDAOImpl();
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	public ServiceResponse addCategory(@RequestBody CategoryMsg categoryMsg){
		ServiceResponse sr = new ServiceResponse();
		if(StringUtils.isBlank(categoryMsg.getFirstCate())){
			sr.error("msg","一级类别不能为空");
			return sr;
		}
		if(StringUtils.isNotBlank(categoryMsg.getThirdCate()) && StringUtils.isBlank(categoryMsg.getSecondCate())){
			sr.error("msg","二级类别不能为空");
			return sr;
		}
		EshopCategory category1 = new EshopCategory();
		category1.setCategoryName(categoryMsg.getFirstCate());
		category1.setRank(1);//设置级别
		try {
			eshopCategoryDAOImpl.insert(category1);//获取id
			logger.info(category1.toString());
			category1.setParentId(category1.getId());
			eshopCategoryDAOImpl.updateByPrimaryKey(category1);//设置父类别id
		} catch (IOException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EshopCategory category2 = null;
		if(StringUtils.isNotBlank(categoryMsg.getSecondCate())){
			category2 = new EshopCategory();
			category2.setCategoryName(categoryMsg.getSecondCate());
			category2.setParentId(category1.getId());
			category2.setRank(2);
			try {
				eshopCategoryDAOImpl.insert(category2);//获取id
				logger.info(category2.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		if(StringUtils.isNotBlank(categoryMsg.getThirdCate())){
			EshopCategory category3 = new EshopCategory();
			category3.setCategoryName(categoryMsg.getThirdCate());
			category3.setParentId(category2.getId());
			category3.setRank(3);
			try {
				eshopCategoryDAOImpl.insert(category3);//获取id
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sr.put("msg","类别添加成功！");
		return sr;
	}
	
	@RequestMapping(value = "/queryFirst",method = RequestMethod.GET)
	@ResponseBody
	public ServiceResponse queryFirst(@RequestParam Integer rank){
		ServiceResponse sr = new ServiceResponse();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("rank",rank);
		try {
			List<EshopCategory> categorys = eshopCategoryDAOImpl.selectByParams(params);
			sr.put("categorys",categorys);
			return sr;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/query",method = RequestMethod.GET)
	@ResponseBody
	public ServiceResponse querySecond(@RequestParam Integer rank,Long parentId){
		ServiceResponse sr = new ServiceResponse();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("rank",rank);
		params.put("parentId",parentId);
		try {
			List<EshopCategory> categorys = eshopCategoryDAOImpl.selectByParams(params);
			sr.put("categorys",categorys);
			return sr;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
