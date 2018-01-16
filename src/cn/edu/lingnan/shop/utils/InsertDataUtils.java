package cn.edu.lingnan.shop.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
	//写到的文件
	private static FileOutputStream fout = null;
	
	static{
		try {
			fout = new FileOutputStream(new File("F://file.txt"));
			System.out.println(fout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
	
	public static void writeToString(String sql){
		try {
			fout.write((sql + "\n").getBytes("GBK"));
			fout.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static String listToString(List list, char separator) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append(separator);    
		}    
		return sb.toString().substring(0,sb.toString().length()-1);}
}



@SuppressWarnings("unchecked")
@Component
public class InsertDataUtils {
	String pathName = "text.json";
	private List<String> images;//图片集合
	private List<String> tags;//具体种类商品特性
	private String title;//商品名
	private Double price;//商品价格
	
	
	/**
	 * 男衬衫的数据商品表插入
	 */
	public void insertProduct(){
		Product product = new Product(this.title);
		product.setFromtable("phone");
		Category category = new Category();
		User user = new User();
		user.setId(3L);
		category.setId(3L);
		product.setCategory(category);
		//价格
		product.setPrice(this.price);
		//库存
		product.setSurplus((long) InsertUtils.getPrice());
		//设置商家
		product.setUser(user);
		//日期
		product.setProductdate(new Date());
		
		
		String sql = String.format("insert into product"
				+ "(id, name, price, transfee, surplus, productDate, detail, fromtable, categoryid, userid)"
				+ " values(seq_prot.nextval, '%s', %f, %d, %d, to_date('%s', 'yyyy-mm-dd'), '%s', 'clothes', 3, 3);",
					product.getName(), price,InsertUtils.getRandomInteger(), product.getSurplus(), DateFormatUtils.format(product.getProductdate()), InsertUtils.listToString(tags, ','));
		InsertUtils.writeToString(sql);
		//循环插入图片
		for (String image: this.images){
			image = "https:" + image;
			sql = String.format("insert into product_pic"
					+ " values(seq_ppic.nextval, '%s', seq_prot.currval);", image);
			InsertUtils.writeToString(sql);
		}
	}
	//插入具体的商品细节
//	public void insertConcrete(){
//		Clothes clothes = new Clothes();
//		clothes.setClothessize(this.tags.get(6));
//		clothes.setMadeof(this.tags.get(7));
//		clothes.setStyle(this.tags.get(10));
//		clothes.setType("衬衫");
//		
//		String sql = String.format("insert into clothes"
//				+ " values(seq_prot.currval, '%s', '%s', '%s', '%s', '%s', %d);"
//				, clothes.getClothessize(), clothes.getBrand(), clothes.getStyle(), clothes.getMadeof(), clothes.getType(), 3);
//		InsertUtils.writeToString(sql);
//	}
	
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
		new InsertDataUtils().insertPrepare(null);
		InsertUtils.writeToString("");
	}
}
