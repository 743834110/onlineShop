package cn.edu.lingnan.shop.service;

import java.util.List;

import cn.edu.lingnan.shop.pojo.Category;
import cn.edu.lingnan.shop.pojo.Clothes;
import cn.edu.lingnan.shop.pojo.Product;
import cn.edu.lingnan.shop.pojo.ProductImages;

public interface ProductService {
	
	//获取商品类型
	public List<Category> findAllCates();
	
	//插入商品clothes
	public Long saveClothes(Clothes clothes);
	
	//根据id获取Category
	public Category getCateById(Long id);
	
	//直接sql语句插入product记录
//	public void saveProductBySql(Product product);
	
	//根据id查product
	public Product getProductById(Long id);
	
	//保存图片
	public void saveImages(ProductImages productImages);
	
	public void saveProduct(Product product);
	
	//根据关键字和大小返回字符序列
	public List<String> getProductByNameWithLimit(String keyword, int limitSize);
	
	//根据名字获取商品
	public List<Product> getProductByName(String keyword);
}
