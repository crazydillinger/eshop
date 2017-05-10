package com.java.eshop.web.dao;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;

import com.java.eshop.commons.DBAcess;
import com.java.eshop.web.model.po.EshopUser;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class TestDao {
	
	public static void main(String[] args) {
		
		DBAcess dbAcess = new DBAcess();
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = dbAcess.getSqlSession();
//			EshopUser user = sqlSession.selectOne("eshop_user_sqlmap.selectUserByPrimaryKey", 1);
			
//			sqlSession.delete("eshop_user_sqlmap.deleteByPrimaryKey", 2);
//			sqlSession.commit();
			
//			EshopUser user = new EshopUser();
//			user.setUserMail("商店");
//			user.setUsername("hhh");
//			user.setAddTime(new Date());
//			user.setUpdTime(new Date());
//			sqlSession.insert("eshop_user_sqlmap.insert", user);
//			sqlSession.commit();
			
//			EshopUser user = new EshopUser();
//			user.setId(new Long(1));
//			user.setUsername("update");
//			sqlSession.update("eshop_user_sqlmap.updateByPrimaryKey", user);
//			sqlSession.commit();
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("username","%hh%");
			params.put("realName", "ck");
			java.util.List<EshopUser> list = sqlSession.selectList("eshop_user_sqlmap.selectByParams", params);
//			Map<String, Object> params = new HashMap<String, Object>();
//			Integer integer  = sqlSession.selectOne("eshop_user_sqlmap.selectCount", params);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
