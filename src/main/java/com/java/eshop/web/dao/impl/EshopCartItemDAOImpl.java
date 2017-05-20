package com.java.eshop.web.dao.impl;

import java.io.IOException;
import java.util.List;

import com.java.eshop.commons.DBAcess;
import com.java.eshop.web.dao.EshopCartItemDAO;
import com.java.eshop.web.model.po.EshopCartItem;

public class EshopCartItemDAOImpl implements EshopCartItemDAO {

	/**
	 * 由id查询购物车子项
	 * @throws IOException 
	 */
	@Override
	public EshopCartItemDAO selectByPrimaryKey(Long id) throws IOException {	
		return DBAcess.getSqlSession().selectOne("eshop_cartitem_sqlmap.selectByPrimaryKey", id);
	}

	/**
	 * 由cartId查询购物车子项
	 * @throws IOException 
	 */
	@Override
	public List<EshopCartItem> selectByCartId(Long id) throws IOException {
		return DBAcess.getSqlSession().selectOne("eshop_cartitem_sqlmap.selectByCartId", id);
	}

	/**
	 * 添加购物车子项
	 * @throws IOException 
	 */
	@Override
	public void insert(EshopCartItem record) throws IOException {
		DBAcess.getSqlSession().insert("eshop_cartitem_sqlmap.insert", record);
		DBAcess.commit();
	}

	/**
	 * 由id删除购物车子项
	 * @throws IOException 
	 */
	@Override
	public void deleteByPrimaryKey(Long id) throws IOException {
		DBAcess.getSqlSession().delete("eshop_cartitem_sqlmap.deleteByPrimaryKey", id);
		DBAcess.commit();
	}

	/**
	 * 由id更新购物车子项
	 * @throws IOException 
	 */
	@Override
	public void updateByPrimaryKey(EshopCartItem record) throws IOException {	
		DBAcess.getSqlSession().update("eshop_cartitem_sqlmap.updateByPrimaryKey", record);
		DBAcess.commit();
	}

}
