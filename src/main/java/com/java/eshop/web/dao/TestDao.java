package com.java.eshop.web.dao;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.spi.LoggerFactory;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.slf4j.Logger;

import com.java.eshop.commons.DBAcess;

public class TestDao {
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(TestDao.class);
	public static void main(String[] args) {
		
		DBAcess dbAcess = new DBAcess();
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = dbAcess.getSqlSession();
			logger.info("SQLSESSION:" + sqlSession);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
