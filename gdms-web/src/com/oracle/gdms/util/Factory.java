package com.oracle.gdms.util;

import java.util.ResourceBundle;

public class Factory {
 private Factory() {}
	
	private static Factory fac = null;

	public static Factory getInstance() {
		// TODO Auto-generated method stub
		fac = fac == null ? new Factory() : fac;
		return fac;
	}
private static ResourceBundle rb=null;//定义一个资源绑定对象
	
	static {
		rb = ResourceBundle.getBundle("config/application");
	}
	
	public Object getObject(String key) {
		String clsname = rb.getString(key);
		try {
			return Class.forName(clsname).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	


}
