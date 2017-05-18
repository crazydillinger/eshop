package com.java.eshop.commons;


import static org.hamcrest.CoreMatchers.nullValue;

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
	
	private static final String RESOURCE = "mybatis/SqlMapConfig.xml";
	
	private static SqlSessionFactory sqlSessionFactory; 
	
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	/**
	 * 加载SqlSessionFactory
	 */
	static{
		try {
			InputStream input = Resources.getResourceAsStream(RESOURCE);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
			logger.info("加载sqlSessionFactory...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获得sqlSession
	 * @return
	 * @throws IOException
	 */
	public static SqlSession getSqlSession() throws IOException{
	
		SqlSession sqlSession = threadLocal.get();
		
		if(sqlSession == null){
			sqlSession = sqlSessionFactory.openSession();
			threadLocal.set(sqlSession);
		}
		
		logger.info("获取sqlSeesion");
		return sqlSession;
	}
	
	/**
	 * 关闭sqlSeesion
	 */
	public static void closeSqlSession(){
		SqlSession sqlSession = threadLocal.get();
		threadLocal.set(null);
		if(sqlSession != null){
			logger.info("关闭sqlSession...");
			sqlSession.close();
		}
	}
	
	/**
	 * 提交事务
	 */
	public static void commit(){
		SqlSession sqlSession = threadLocal.get();
		if(sqlSession == null){
			throw new RuntimeException("还没有获得sqlSession连接");
		}
		logger.info("提交事务...");
		sqlSession.commit();
	}
}
