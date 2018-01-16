package cn.edu.lingnan.shop.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
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
import cn.edu.lingnan.shop.pojo.Tally;
import cn.edu.lingnan.shop.service.ClothesService;
import cn.edu.lingnan.shop.service.ProductService;
import cn.edu.lingnan.shop.service.TallyService;
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
public class ServiceUtils {
	
	private static ServiceUtils serviceUtils = null;
	//根据数据类型进行自动注入
	
	@Autowired
	private TallyService tallyService;
	
	@PostConstruct
	//把对象传递过来
	public void init(){
		System.out.println("被调用");
		serviceUtils = this;
	}
	
	//获取实例
	public static ServiceUtils getInstance(){
		return serviceUtils;
	}
	/**
	 * 保存或更新tally实例
	 * @param tally
	 */
	public void mergeTally(Tally tally){
		tally.setId(DateFormatUtils.format(new Date()));
		this.tallyService.mergeTally(tally);
	}
	
	public Serializable saveTally(Tally tally){
		return this.tallyService.saveTally(tally);
	}
	
	/**
	 * 获取tally实例
	 * @return
	 */
	public Tally getTally(){
		Date date = new Date();
		return  this.tallyService.getTallyByDate(date);
	}
}
