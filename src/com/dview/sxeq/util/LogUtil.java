package com.dview.sxeq.util;

import java.io.IOException;
import java.util.Properties;

public class LogUtil {

	private static Properties daopProperties;

	static{
		if(daopProperties == null){
			daopProperties = new Properties();
		}
		try {
			daopProperties.load(LogUtil.class.getClassLoader().getResourceAsStream("log.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getLogContent(String methodName){

		String str = daopProperties.getProperty(methodName);
		return str;
	}
	
	public static void main(String[] args) {
		System.out.println(getLogContent("123"));
	}
}
