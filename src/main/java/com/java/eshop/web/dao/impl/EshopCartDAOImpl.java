package com.java.eshop.web.dao.impl;

import java.io.IOException;

import com.java.eshop.commons.DBAcess;
import com.java.eshop.web.dao.EshopCartDAO;
import com.java.eshop.web.model.po.EshopCart;

public class EshopCartDAOImpl implements EshopCartDAO {
	
	/**
	 * 由id查询购物车
	 * @throws IOException 
	 */
	@Override
	public EshopCart selectByPrimaryKey(Long id) throws IOException {
		return DBAcess.getSqlSession().selectOne("eshop_cart_sqlmap.selectByPrimaryKey", id);
	}

	/**
	 * 由用户id查询购物车
	 * @throws IOException 
	 */
	@Override
	public EshopCart selectByUserId(Long id) throws IOException {
		return DBAcess.getSqlSession().selectOne("eshop_cart_sqlmap.selectByUserId", id);
	}

	/**
	 * 添加购物车
	 * @throws IOException 
	 */
	@Override
	public void insert(EshopCart record) throws IOException {
		DBAcess.getSqlSession().insert("eshop_cart_sqlmap.insert",record);
		DBAcess.commit();
	}

	/**
	 * 由cartId更新购物车
	 * @throws IOException 
	 */
	@Override
	public void updateByPrimaryKey(EshopCart record) throws IOException {
		DBAcess.getSqlSession().update("eshop_cart_sqlmap.updateByPrimaryKey", record);
		DBAcess.commit();
	}

	/**
	 * 由id删除购物车
	 * @throws IOException 
	 */
	@Override
	public void deleteByPrimaryKey(Long id) throws IOException {
		DBAcess.getSqlSession().delete("eshop_cart_slqmap.deleteByPrimaryKey", id);
		DBAcess.commit();
	}

}
