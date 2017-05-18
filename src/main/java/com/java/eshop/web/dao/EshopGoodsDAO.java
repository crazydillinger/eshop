package com.java.eshop.web.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.java.eshop.web.model.po.EshopGoods;

public interface EshopGoodsDAO {
	
	EshopGoods selectByPrimaryKey(Long id) throws IOException;
	
	List<EshopGoods> selectByGoodsName(String name)throws IOException;
	
	void insert(EshopGoods record)throws IOException;
	
	void deleteByPrimaryKey(Long id)throws IOException;
	
	void updateByPrimaryKey(EshopGoods record)throws IOException;	
	
	List<EshopGoods> selectByParams(Map<String,Object> params)throws IOException;
}
