package com.java.eshop.web.dao;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;

import com.java.eshop.commons.DBAcess;
import com.java.eshop.web.model.po.EshopUser;

public class TestDao {
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(TestDao.class);
	public static void main(String[] args) {
		
		DBAcess dbAcess = new DBAcess();
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = dbAcess.getSqlSession();
			EshopUser user = sqlSession.selectOne("eshop_user_sqlmap.selectUserByPrimaryKey", 1);
			logger.info("SQLSESSION:" + sqlSession);
			logger.info("USER:" + user.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
