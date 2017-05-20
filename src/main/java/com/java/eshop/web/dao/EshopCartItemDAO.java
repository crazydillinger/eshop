package com.java.eshop.web.dao;

import java.io.IOException;
import java.util.List;

import com.java.eshop.web.model.po.EshopCartItem;

public interface EshopCartItemDAO {
	
	EshopCartItemDAO selectByPrimaryKey(Long id) throws IOException;
	
	List<EshopCartItem> selectByCartId(Long id)throws IOException;
	
	void insert(EshopCartItem record)throws IOException;
	
	void deleteByPrimaryKey(Long id)throws IOException;
	
	void updateByPrimaryKey(EshopCartItem record)throws IOException;
}
