package com.java.eshop.web.dao.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.java.eshop.commons.DBAcess;
import com.java.eshop.web.dao.EshopCategoryDAO;
import com.java.eshop.web.model.po.EshopCategory;

public class EshopCategoryDAOImpl implements EshopCategoryDAO{
	/**
	 * 由id查询商品类别
	 * @throws IOException 
	 */
	@Override
	public EshopCategory selectByPrimaryKey(Long id) throws IOException {
		EshopCategory db= DBAcess.getSqlSession().selectOne("eshop_category_sqlmap.selectByPrimaryKey", id);
		return db;
	}

	/**
	 * 由参数查询商品类别
	 * @throws IOException 
	 */
	@Override
	public List<EshopCategory> selectByParams(Map<String, Object> params) throws IOException {
		return DBAcess.getSqlSession().selectList("eshop_category_sqlmap.selectByParams", params);
	}

	/**
	 * 添加商品类别
	 * @throws IOException 
	 */
	@Override
	public void insert(EshopCategory record) throws IOException {
		DBAcess.getSqlSession().insert("eshop_category_sqlmap.insert", record);
		DBAcess.commit();
	}

	/**
	 * 由id删除商品类别
	 * @throws IOException 
	 */
	@Override
	public void deleteByPrimaryKey(Long id) throws IOException {
		DBAcess.getSqlSession().delete("eshop_category_sqlmap.deleteByPrimaryKey", id);
		DBAcess.commit();
	}

	/**
	 * 更新商品类别
	 * @throws IOException 
	 */
	@Override
	public void updateByPrimaryKey(EshopCategory record) throws IOException {
		DBAcess.getSqlSession().update("eshop_category_sqlmap.updateByPrimaryKey", record);
		DBAcess.commit();
	}
}
