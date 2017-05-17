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
	 * ����id��ѯ�û�
	 */
	@Override
	public EshopUser selectUserByPrimaryKey(Long id) throws IOException {
		EshopUser user = DBAcess.getSqlSession().selectOne("eshop_user_sqlmap.selectUserByPrimaryKey", id);
		return user;
	}
	
	/**
	 * �����û�����ѯ�û�
	 */
	public EshopUser selectByUsername(String username) throws IOException{
		return DBAcess.getSqlSession().selectOne("eshop_user_sqlmap.selectByUsername", username);
	}

	/**
	 * ����idɾ���û�
	 */
	@Override
	public void deleteByPrimaryKey(Long id) throws IOException {
		DBAcess.getSqlSession().delete("eshop_user_sqlmap.deleteByPrimaryKey", id);
	}

	/**
	 * �����û�����
	 */
	@Override
	public void insert(EshopUser record) throws IOException {
		DBAcess.getSqlSession().insert("eshop_user_sqlmap.insert", record);
	}

	/**
	 * �����û�����
	 */
	@Override
	public void updateByPrimaryKey(EshopUser record) throws IOException {
		DBAcess.getSqlSession().update("eshop_user_sqlmap.updateByPrimaryKey", record);
	}

	/**
	 * ����������ѯ�û�
	 */
	@Override
	public List<EshopUser> selectByParams(Map<String, Object> params) throws IOException {
		List<EshopUser> list = DBAcess.getSqlSession().selectList("eshop_user_sqlmap.selectByParams", params);
		return list;
	}

	/**
	 * ����������ѯ�û�����
	 */
	@Override
	public Integer selectCount(Map<String, Object> params) throws IOException {
		Integer count = DBAcess.getSqlSession().selectOne("eshop_user_sqlmap.selectCount", params);
		return count;
	}

}
