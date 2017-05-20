package com.java.eshop.web.dao;

import java.io.IOException;

import com.java.eshop.web.model.po.EshopCart;

public interface EshopCartDAO {
	
	EshopCart selectByPrimaryKey(Long id) throws IOException;
	
	EshopCart selectByUserId(Long id)throws IOException;
	
	void insert(EshopCart record)throws IOException;
	
	void updateByPrimaryKey(EshopCart record)throws IOException;
	
	void deleteByPrimaryKey(Long id)throws IOException;
}
