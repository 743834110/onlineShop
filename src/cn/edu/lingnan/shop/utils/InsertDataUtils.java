package cn.edu.lingnan.shop.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import cn.edu.lingnan.shop.dao.CategoryDao;
import cn.edu.lingnan.shop.dao.ClothesDao;
import cn.edu.lingnan.shop.dao.ProductDao;
import cn.edu.lingnan.shop.dao.ProductImagesDao;
import cn.edu.lingnan.shop.pojo.Category;
import cn.edu.lingnan.shop.pojo.Clothes;
import cn.edu.lingnan.shop.pojo.Product;
import cn.edu.lingnan.shop.pojo.ProductImages;
import cn.edu.lingnan.shop.pojo.User;

/**
 * 
 * 用于进行数据插入的类
 * @author Administrator
 *
 */

class InsertUtils{
	//运费
	private static int[] transfee = {0, 0, 8, 16, 20};
	//随机价格生成
	public static double getPrice(){
		Random random = new Random();
		return 30 + random.nextDouble() * 400;
	}
	
	//获取json数据
	public static String getJSON(String fileName) throws FileNotFoundException{
		File file = ResourceUtils.getFile("classpath:" + fileName);
		StringBuffer sBuf = new StringBuffer();
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()){
			sBuf.append(scanner.nextLine());
		}
		return sBuf.toString();
	}
	
	public static int getRandomInteger(){
		
		Random random = new Random();
		return transfee[random.nextInt(5)];
	}
}



@SuppressWarnings("unchecked")
@Component
public class InsertDataUtils {
	String pathName = "text.json";
	private List<String> images;//图片集合
	private List<String> tags;//具体种类商品特性
	private String title;//商品名
	private Double price;//商品价格
	public static InsertDataUtils dataUtils;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ClothesDao clothesDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductImagesDao productImagesDao;
	
	//@PostConstruct
	public void init() throws FileNotFoundException{
		System.out.println("注入成功");
		dataUtils = this;
		this.insertPrepare(null);
	}
	
	/**
	 * 男衬衫的数据商品表插入
	 */
	public void insertProduct(){
		Product product = new Product(this.title);
		product.setFromtable("clothes");
		Category category = new Category();
		User user = new User();
		user.setId(3L);
		category.setId(3L);
		product.setCategory(category);
		//材质
		product.setMadein(this.tags.get(7));
		//价格
		product.setPrice(this.price);
		//库存
		product.setSurplus((long) InsertUtils.getPrice());
		//设置商家
		product.setUser(user);
		//日期
		product.setProductdate(new Date());
		Serializable id = this.productDao.save(product);
		product.setId((Long) id);
		//循环插入图片
		for (String image: this.images){
			image = "https:" + image;
			ProductImages entity = new ProductImages();
			entity.setPath(image);
			entity.setProduct(product);
			this.productImagesDao.save(entity);
		}
		this.insertConcrete((Long) id);
	}
	//插入具体的商品细节
	public void insertConcrete(Long id){
		Clothes clothes = new Clothes();
		clothes.setClothessize(this.tags.get(6));
		clothes.setMadeof(this.tags.get(7));
		clothes.setStyle(this.tags.get(10));
		clothes.setType("衬衫");
		this.clothesDao.save(clothes);
	}
	
	//数据准备
	public InsertDataUtils insertPrepare(String path) throws FileNotFoundException{
		String jsonString = InsertUtils.getJSON(pathName);
		System.out.println(jsonString);
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		int size = jsonArray.size();
		for (int i = 0; i < size; i++){
			JSONObject obj = jsonArray.getJSONObject(i);
			this.title = (String) obj.get("title");
			this.images = (List<String>) JSONArray.toCollection((JSONArray) obj.get("image"));
			this.tags = (List<String>) JSONArray.toCollection(obj.getJSONArray("extra"));
			this.price = null;
			try{
				this.price = obj.getDouble("price");
			}
			catch (Exception e){
				this.price = InsertUtils.getPrice();
			}
			this.insertProduct();
		}
		return this;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(InsertUtils.getRandomInteger());
//		new InsertDataUtils()
//			.insertPrepare(null)
//			.insertClothes();
//		//System.out.println(InsertUtils.getJSON("男衬衫.json").length());
	}
}
