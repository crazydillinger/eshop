package com.java.eshop.commons;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DBAcess {
	
	private static final Logger logger = LoggerFactory.getLogger(DBAcess.class);
	
	public static SqlSession getSqlSession() throws IOException{
		InputStream input = Resources.getResourceAsStream("mybatis/SqlMapConfig.xml");
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		logger.info("连接数据库成功");
		
		return sqlSession;
	}
}
