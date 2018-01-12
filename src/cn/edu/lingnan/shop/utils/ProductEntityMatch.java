package cn.edu.lingnan.shop.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


/**
 * 商品实体匹配类
 * 负责表明和类名简单映射
 * @author tianFeng
 *
 */
public class ProductEntityMatch {
	private static Properties properties = null;
	static{
		String basePath = ProductEntityMatch.class.getClassLoader()
				.getResource("productMatch.properties").getPath();
		try {
			properties =  new Properties();
			properties.loadFromXML(new FileInputStream(basePath));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static Class<?> match(String tableName){
		if (properties == null)
			return null;
		String target =  (String) properties.get(tableName);
		System.out.println(target);
		Class<?> cls = null;
		try {
			cls = java.lang.Class.forName(target);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cls;
	}
	
	public static void main(String[] args) {
		match("clothes");
	}
}
