package com.java.eshop.web.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.java.eshop.web.model.po.EshopUser;

public interface EshopUserDAO {
	
	EshopUser selectUserByPrimaryKey(Long id) throws IOException;
	
	public EshopUser selectByUsername(String username) throws IOException;
	
	void deleteByPrimaryKey(Long id) throws IOException;
	
	void insert(EshopUser record) throws IOException;
	
	void updateByPrimaryKey(EshopUser record) throws IOException;
	
	java.util.List<EshopUser> selectByParams(Map<String, Object> params) throws IOException;
	
	Integer selectCount(Map<String, Object> params) throws IOException;
}
