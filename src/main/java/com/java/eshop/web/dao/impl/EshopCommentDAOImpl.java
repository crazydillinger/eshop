package com.java.eshop.web.dao.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.java.eshop.commons.DBAcess;
import com.java.eshop.web.dao.EshopCommentDAO;
import com.java.eshop.web.model.po.EshopComment;

public class EshopCommentDAOImpl implements EshopCommentDAO{
	
	/**
	 * 根据id查询商品评论
	 * @throws IOException 
	 */
	@Override
	public EshopComment selectByPrimaryKey(Long id) throws IOException {
		EshopComment db = DBAcess.getSqlSession().selectOne("eshop_comment_sqlmap.selectByPrimaryKey", id);
		return db;
	}

	/**
	 * 根据商品id查询商品评论
	 * @throws IOException 
	 */
	@Override
	public List<EshopComment> selectByProductId(Long id) throws IOException {
		List<EshopComment> db = DBAcess.getSqlSession().selectList("eshop_comment_sqlmap.selectByProductId", id);
		return db;
	}

	/**
	 * 用户id查询商品评论
	 * @throws IOException 
	 */
	@Override
	public List<EshopComment> selectByUserId(Long id) throws IOException {
		List<EshopComment> db = DBAcess.getSqlSession().selectList("eshop_comment_sqlmap.selectByUserId", id);
		return db;
	}

	/**
	 * 根据map查询评论
	 * @throws IOException 
	 */
	@Override
	public List<EshopComment> selectByParams(Map<String, Object> params) throws IOException {
		List<EshopComment> dbs = DBAcess.getSqlSession().selectList("eshop_comment_sqlmap.selectByParams", params);
		return dbs;
	}

	/**
	 * 插入评论
	 * @throws IOException 
	 */
	@Override
	public void insert(EshopComment record) throws IOException {
		DBAcess.getSqlSession().insert("eshop_comment_sqlmap.insert", record);
		DBAcess.commit();
	}

	/**
	 * 由id删除评论
	 * @throws IOException 
	 */
	@Override
	public void deleteByPrimaryKey(Long id) throws IOException {
		DBAcess.getSqlSession().delete("eshop_comment_sqlmap.deleteByPrimaryKey", id);
		DBAcess.commit();
	}

	/**
	 * 由id更新评论
	 * @throws IOException 
	 */
	@Override
	public void updateByPrimaryKey(EshopComment record) throws IOException {
		DBAcess.getSqlSession().update("eshop_comment_sqlmap.updateByPrimaryKey", record);
		DBAcess.commit();
	}
}
