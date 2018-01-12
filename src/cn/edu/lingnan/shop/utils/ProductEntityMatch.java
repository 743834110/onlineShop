package cn.edu.lingnan.shop.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.regex.Matcher;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.opensymphony.xwork2.config.Configuration;
import com.opensymphony.xwork2.config.ConfigurationUtil;

import cn.edu.lingnan.shop.pojo.Clothes;
import cn.edu.lingnan.shop.service.ClothesService;
import cn.edu.lingnan.shop.service.ProductService;
import cn.edu.lingnan.shop.service.impl.ClothesServiceImpl;


/**
 * 商品实体匹配类
 * 负责表明和类名简单映射
 * 
 * 让普通类调用spring bean 托管的
 * 对象的先决条件：
 * 把该包加入到将要被扫描入户的配置文件当中
 * 标注某类需要被容器托管（作为容器对象组件存在(component)）
 * 用@postConstruct 标注 实例化对象后要运行的方法
 * 然后取对象即可
 * 
 * @author tianFeng
 *
 */
@Component
public class ProductEntityMatch {
	
	private static ProductEntityMatch matcher;
	private ApplicationContext context = null;
	//根据数据类型进行自动注入
	@Autowired
	private ClothesService productService;
//	static{
//		try {
//			File file =  ResourceUtils.getFile("classpath:productMatch.properties");
//			properties =  new Properties();
//			properties.loadFromXML(new FileInputStream(file));
//		} catch (FileNotFoundException e) {			
//			e.printStackTrace();
//		} catch (IOException e) {			
//			e.printStackTrace();
//		}
//	}

	@PostConstruct
	//把对象传递过来
	public void init(){
		System.out.println("被调用");
		matcher = this;
	}
	
	//获取实例
	public static ProductEntityMatch getInstance(){
		return matcher;
	}
	
	public <T> T match(Class<T> cls){
		T instance = null;
		
		return instance;
	}
	
}
