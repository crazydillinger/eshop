package com.java.eshop.web.dao;

import java.io.IOException;
import java.util.List;

import com.java.eshop.web.model.po.EshopFavorite;

public interface EshopFavoriteDAO {
	
	EshopFavorite selectByPrimaryKey(Long id)throws IOException;
	
	List<EshopFavorite >selectByUserId(Long id)throws IOException;
	
	void insert(EshopFavorite record)throws IOException;
	
	void deleteByPrimaryKey(Long id)throws IOException;
}
