package com.java.eshop.web.dao.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.java.eshop.commons.DBAcess;
import com.java.eshop.web.dao.EshopAddressDAO;
import com.java.eshop.web.model.po.EshopAddress;

public class EshopAddressDAOImpl implements EshopAddressDAO{

	@Override
	public EshopAddress selectByPrimaryKey(Long id) throws IOException {
		return DBAcess.getSqlSession().selectOne("eshop_address_sqlmap.selectByPrimaryKey", id);
	}

	@Override
	public List<EshopAddress> selectByUserId(Long id) throws IOException {
		return DBAcess.getSqlSession().selectList("eshop_address_sqlmap.selectByUserId", id);
	}

	@Override
	public List<EshopAddress> selectByParams(Map<String, Object> params) throws IOException {
		return DBAcess.getSqlSession().selectList("eshop_address_sqlmap.selectByParams", params);
	}

	@Override
	public void insert(EshopAddress record) throws IOException {
		DBAcess.getSqlSession().insert("eshop_address_sqlmap.insert", record);
		DBAcess.commit();
	}

	@Override
	public void deleteByPrimaryKey(Long id) throws IOException {
		DBAcess.getSqlSession().delete("eshop_address_sqlmap.deleteByPrimaryKey", id);
		DBAcess.commit();
	}

	@Override
	public void updateByPrimaryKey(EshopAddress record) throws IOException {
		DBAcess.getSqlSession().update("eshop_address_sqlmap.updateByPrimarKey", record);
		DBAcess.commit();
	}

}
