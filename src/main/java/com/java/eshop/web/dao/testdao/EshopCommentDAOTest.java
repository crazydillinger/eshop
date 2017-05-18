package com.java.eshop.web.dao.testdao;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.omg.CORBA.COMM_FAILURE;

import com.java.eshop.commons.DBAcess;
import com.java.eshop.web.model.po.EshopComment;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class EshopCommentDAOTest {
public static void main(String[] args) {
		
		DBAcess dbAcess = new DBAcess();
		
		SqlSession sqlSession = null;
	
		try {
			sqlSession = dbAcess.getSqlSession();
//			EshopComment comment = new EshopComment(new Long(0),"title","comment",5,new Long(1),new Long(1),new Date(),new Date());
//			sqlSession.insert("eshop_comment_sqlmap.insert", comment);
//			sqlSession.commit();
//			sqlSession.delete("eshop_comment_sqlmap.deleteByPrimaryKey", 2);
//			sqlSession.delete("eshop_comment_sqlmap.deleteByPrimaryKey", 4);
//			sqlSession.commit();
//			EshopComment comment = new EshopComment(new Long(5),"update","comment",5,new Long(1),new Long(1),new Date(),new Date());
//			sqlSession.update("eshop_comment_sqlmap.updateByPrimaryKey", comment);
//			sqlSession.commit();
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("start", 0);
			params.put("end", 10);
			List<EshopComment> dbComments = sqlSession.selectList("eshop_comment_sqlmap.selectByParams", params);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
