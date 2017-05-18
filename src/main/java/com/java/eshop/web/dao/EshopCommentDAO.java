package com.java.eshop.web.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.java.eshop.web.model.po.EshopComment;

public interface EshopCommentDAO {
	
	EshopComment selectByPrimaryKey(Long id) throws IOException;
	
	List<EshopComment> selectByProductId(Long id) throws IOException;
	
	List<EshopComment> selectByUserId(Long id) throws IOException;
	
	List<EshopComment> selectByParams(Map<String, Object> params) throws IOException;
	
	void insert(EshopComment record) throws IOException;
	
	void deleteByPrimaryKey(Long id) throws IOException;
	
	void updateByPrimaryKey(EshopComment record)throws IOException;
}
