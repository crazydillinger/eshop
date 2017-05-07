package com.java.eshop.commons;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ServiceResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected String code;
	
	protected String msg;
	
	protected Map<String, Object> data;
	
	public <T> T put(String key, T value){
		if(null == data){
			data = new HashMap<String, Object>();
		}
		return (T)data.put(key, value);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ServiceResponse [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
}
