package cn.edu.lingnan.shop.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import com.opensymphony.xwork2.config.Configuration;
import com.opensymphony.xwork2.config.ConfigurationUtil;

import cn.edu.lingnan.shop.service.ProductService;


/**
 * 商品实体匹配类
 * 负责表明和类名简单映射
 * @author tianFeng
 *
 */
public class ProductEntityMatch {
	
	private static ProductEntityMatch matcher = new ProductEntityMatch();
	@Autowired
	private ProductService productService;
	
	private static Properties properties = null;
	static{
		try {
			File file =  ResourceUtils.getFile("classpath:productMatch.properties");
			System.out.println(file.toString());
			properties =  new Properties();
			properties.loadFromXML(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static ProductEntityMatch getInstance(){
		return matcher;
	}
	
	public  Class<?> match(String tableName){
		if (properties == null)
			return null;
		String target =  (String) properties.get(tableName);
		System.out.println("表名："+tableName);
		Class<?> cls = null;
		try {
			cls = java.lang.Class.forName(target);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.productService);
		return cls;
	}
	
	
	
	public static void main(String[] args) {
		ProductEntityMatch.getInstance().match("clothes");
	}
}
