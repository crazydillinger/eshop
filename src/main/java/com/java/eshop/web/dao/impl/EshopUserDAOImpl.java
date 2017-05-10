package com.java.eshop.web.dao.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.java.eshop.commons.DBAcess;
import com.java.eshop.web.dao.EshopUserDAO;
import com.java.eshop.web.model.po.EshopUser;

public class EshopUserDAOImpl implements EshopUserDAO{
	/**
	 * 根据id查询用户
	 */
	@Override
	public EshopUser selectUserByPrimaryKey(Long id) throws IOException {
		EshopUser user = DBAcess.getSqlSession().selectOne("eshop_user_sqlmap.selectUserByPrimaryKey", id);
		return user;
	}

	/**
	 * 根据id删除用户
	 */
	@Override
	public void deleteByPrimaryKey(Long id) throws IOException {
		DBAcess.getSqlSession().delete("eshop_user_sqlmap.deleteByPrimaryKey", id);
	}

	/**
	 * 插入用户数据
	 */
	@Override
	public void insert(EshopUser record) throws IOException {
		DBAcess.getSqlSession().insert("eshop_user_sqlmap.insert", record);
	}

	/**
	 * 更新用户数据
	 */
	@Override
	public void updateByPrimaryKey(EshopUser record) throws IOException {
		DBAcess.getSqlSession().update("eshop_user_sqlmap.updateByPrimaryKey", record);
	}

	/**
	 * 根据条件查询用户
	 */
	@Override
	public List<EshopUser> selectByParams(Map<String, Object> params) throws IOException {
		List<EshopUser> list = DBAcess.getSqlSession().selectList("eshop_user_sqlmap.selectByParams", params);
		return list;
	}

	/**
	 * 根据条件查询用户个数
	 */
	@Override
	public Integer selectCount(Map<String, Object> params) throws IOException {
		Integer count = DBAcess.getSqlSession().selectOne("eshop_user_sqlmap.selectCount", params);
		return count;
	}

}
