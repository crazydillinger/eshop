package com.java.eshop.web.service;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;

import com.java.eshop.commons.ServiceResponse;
import com.java.eshop.web.dao.impl.EshopUserDAOImpl;
import com.java.eshop.web.model.para.LoginMessege;
import com.java.eshop.web.model.po.EshopUser;

public class EshopUserService {
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(EshopUserService.class);
	
	EshopUserDAOImpl userDAOImpl = new EshopUserDAOImpl();
	
	public void login(LoginMessege user,ServiceResponse sr){
		//�鿴Ȩ��
		//����session
		if(null == user.getUsername()){
			sr.error("msg", "�������û���");
			return;
		}
		if(null == user.getPassword()){
			sr.error("msg","����������");
			return;
		}
		Map<String , Object> params = new HashMap<String,Object>();
		params.put("username", user.getUsername());
		List<EshopUser> users = null;
		try {
			users =  userDAOImpl.selectByParams(params);
		} catch (IOException e) {
			logger.info(e.getMessage());
		} finally {
			if(null == users || users.size() == 0){
				sr.error("msg", "�û������������!");
				return;
			}
		}
		if(!user.getPassword().equals(users.get(0).getPassword())){
			sr.error("msg", "�û������������!");
			return;
		}
		sr.put("msg", "��½�ɹ�");
	}
}
