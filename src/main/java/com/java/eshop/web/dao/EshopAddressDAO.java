package com.java.eshop.web.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.java.eshop.web.model.po.EshopAddress;

public interface EshopAddressDAO {
	
	public EshopAddress selectByPrimaryKey(Long id)throws IOException;
	
	public List<EshopAddress> selectByUserId(Long id)throws IOException;
	
	public List<EshopAddress> selectByParams(Map<String, Object> params)throws IOException;
	
	public void insert(EshopAddress record)throws IOException;
	
	public void deleteByPrimaryKey(Long id)throws IOException;
	
	public void updateByPrimaryKey(EshopAddress record) throws IOException;

}
