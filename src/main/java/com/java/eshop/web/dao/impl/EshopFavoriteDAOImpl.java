package com.java.eshop.web.dao.impl;

import java.io.IOException;
import java.util.List;

import com.java.eshop.commons.DBAcess;
import com.java.eshop.web.dao.EshopFavoriteDAO;
import com.java.eshop.web.model.po.EshopFavorite;

public class EshopFavoriteDAOImpl implements EshopFavoriteDAO {

	/**
	 * 由主键查询收藏
	 * @throws IOException 
	 */
	@Override
	public EshopFavorite selectByPrimaryKey(Long id) throws IOException {
		return DBAcess.getSqlSession().selectOne("eshop_favorite_sqlmap.selectByPrimaryKey", id);
	}
	
	/**
	 * 添加收藏
	 * @throws IOException 
	 */
	@Override
	public void insert(EshopFavorite record) throws IOException {
		DBAcess.getSqlSession().insert("eshop_favorite_sqlmap.insert", record);
		DBAcess.commit();
	}

	/**
	 * 由主键删除收藏
	 * @throws IOException 
	 */
	@Override
	public void deleteByPrimaryKey(Long id) throws IOException {
		DBAcess.getSqlSession().delete("eshop_favorite_sqlmap.deleteByPrimaryKey", id);
		DBAcess.commit();
	}

	/**
	 * 由用户id查询收藏
	 * @throws IOException 
	 */
	@Override
	public List<EshopFavorite> selectByUserId(Long id) throws IOException {
		return DBAcess.getSqlSession().selectList("eshop_favorite_sqlmap.selectByUserId", id);
	}

}
