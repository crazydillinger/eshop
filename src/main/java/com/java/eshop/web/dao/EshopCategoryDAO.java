package com.java.eshop.web.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.java.eshop.web.model.po.EshopCategory;

public interface EshopCategoryDAO {
	
	EshopCategory selectByPrimaryKey(Long id) throws IOException;
	
	List<EshopCategory> selectByParams(Map<String, Object> params)throws IOException;
	
	void insert(EshopCategory record)throws IOException;
	
	void deleteByPrimaryKey(Long id)throws IOException;
	
	void updateByPrimaryKey(EshopCategory record)throws IOException;
}
