package cn.edu.lingnan.shop.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.lingnan.shop.pojo.Category;
import cn.edu.lingnan.shop.pojo.Clothes;
import cn.edu.lingnan.shop.pojo.Product;
import cn.edu.lingnan.shop.pojo.ProductImages;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.service.ProductService;

/**
 * 商品action
 * 负责和商品有关的数据控制交互
 * @author Administrator
 *
 */

public class ProductAction extends BaseAction {
	
	
	@Autowired
	private ProductService productService;
	
	private List<Category> cateList;
	
	private Clothes clothe;
	
	private Product product;
	
//	private File pic;
//	private String picContentType;
//	private String picFileName;
	
	private File[] pic;
	private String[] picContentType;
	private String[] picFileName; 
	
	private int id;
	
	public String toAdd(){
		cateList = productService.findAllCates();
		return SUCCESS;
	}

	public String addProduct(){
		try {
			
//			System.out.println(product.getDetail());
			ProductImages productImages = new ProductImages();
			User user = (User) this.session.get("user");
			clothe.setUser(user);
			Long productid = productService.saveClothes(clothe);
			
			System.out.println(productid);
			
			product.setCategory(productService.getCateById((long) id));
			product.setId(productid);
			product.setProductdate(new Date());
			System.out.println(product.getId());
			product.setOffshelf(0L);
			product.setFromtable(productService.getCateById((long) id).getFromtable());
			
			productService.saveProduct(product);
			
			String path = this.application.getRealPath("upload");
			
			if(pic != null) {
				File deskFile = new File(path);
				if(!deskFile.getParentFile().exists())
					deskFile.getParentFile().mkdirs();
				for (int i=0;i<pic.length;i++) {
					File saveFile = new File(deskFile,picFileName[i]);
					FileUtils.copyFile(pic[i], saveFile);
					
					productImages.setPath(picFileName[i]);
					productImages.setProduct(productService.getProductById(productid));
					productService.saveImages(productImages);
				}
			}
			
			
			
//			File file = new File(path, picFileName);
//			FileUtils.copyFile(pic, file);
//			
//			productImages.setPath(picFileName);
//			productImages.setProduct(productService.getProductById(productid));
//			productService.saveImages(productImages);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	
	public List<Category> getCateList() {
		return cateList;
	}

	public void setCateList(List<Category> cateList) {
		this.cateList = cateList;
	}

	public Clothes getClothe() {
		return clothe;
	}

	public void setClothe(Clothes clothe) {
		this.clothe = clothe;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	

	public File[] getPic() {
		return pic;
	}

	public void setPic(File[] pic) {
		this.pic = pic;
	}

	public String[] getPicContentType() {
		return picContentType;
	}

	public void setPicContentType(String[] picContentType) {
		this.picContentType = picContentType;
	}

	public String[] getPicFileName() {
		return picFileName;
	}

	public void setPicFileName(String[] picFileName) {
		this.picFileName = picFileName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
