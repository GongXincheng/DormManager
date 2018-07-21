package com.gxc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 项目参数工具类
 */
public class ResourceUtil {

	//方法一：获取properties对应Key的值
	//private static final ResourceBundle bundle = java.util.ResourceBundle.getBundle("config/sysConfig");
	
	//方法二：获取properties对应Key的值
	private static Properties properties = null;
	static{
		try {
			InputStream inputStream = ResourceUtil.class.getClassLoader().getResourceAsStream("config/sysConfig.properties");
			properties = new Properties();
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取随机码的长度
	 * @return 随机码的长度
	 */
	public static String getRandCodeLength() {
		//return bundle.getString("randCodeLength");
		return properties.getProperty("randCodeLength");
	}

	/**
	 * 获取随机码的类型
	 * @return 随机码的类型
	 */
	public static String getRandCodeType() {
		//return bundle.getString("randCodeType");
		return properties.getProperty("randCodeType");
	}

}