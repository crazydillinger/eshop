package com.java.eshop.web.dao.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.java.eshop.commons.DBAcess;
import com.java.eshop.web.dao.EshopGoodsDAO;
import com.java.eshop.web.model.po.EshopGoods;

public class EshopGoodsDAOImpl implements EshopGoodsDAO{

	/**
	 * 由id查询商品
	 * @throws IOException 
	 */
	@Override
	public EshopGoods selectByPrimaryKey(Long id) throws IOException {
		return DBAcess.getSqlSession().selectOne("eshop_goods_sqlmap.selectByPrimaryKey", id);
	}

	/**
	 * 有商品名查询商品
	 * @throws IOException 
	 */
	@Override
	public List<EshopGoods> selectByGoodsName(String name) throws IOException {
		return DBAcess.getSqlSession().selectList("eshop_goods_sqlmap.selectByGoodsName", name);
	}

	/**
	 * 添加商品
	 * @throws IOException 
	 */
	@Override
	public void insert(EshopGoods record) throws IOException {
		DBAcess.getSqlSession().insert("eshop_goods_sqlmap.insert", record);
		DBAcess.commit();
	}

	/**
	 * 由id删除商品
	 * @throws IOException 
	 */
	@Override
	public void deleteByPrimaryKey(Long id) throws IOException {
		DBAcess.getSqlSession().delete("eshop_goods_sqlmap.deleteByPrimaryKey", id);
		DBAcess.commit();
	}

	/**
	 * 更新商品
	 * @throws IOException 
	 */
	@Override
	public void updateByPrimaryKey(EshopGoods record) throws IOException {
		DBAcess.getSqlSession().update("eshop_goods_sqlmap.updateByPrimaryKey", record);
		DBAcess.commit();
	}

	/**
	 *由参数集合查询商品
	 * @throws IOException 
	 */
	@Override
	public List<EshopGoods> selectByParams(Map<String, Object> params) throws IOException {
		return DBAcess.getSqlSession().selectList("eshop_goods_sqlmap.selectByParams", params);
	}

}
