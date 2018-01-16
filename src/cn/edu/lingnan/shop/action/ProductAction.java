package cn.edu.lingnan.shop.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.lingnan.shop.pojo.Category;
import cn.edu.lingnan.shop.pojo.Clothes;
import cn.edu.lingnan.shop.pojo.Comments;
import cn.edu.lingnan.shop.pojo.DownProduct;
import cn.edu.lingnan.shop.pojo.Product;
import cn.edu.lingnan.shop.pojo.ProductImages;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.service.CategoryService;
import cn.edu.lingnan.shop.service.CommentService;
import cn.edu.lingnan.shop.service.DownProductService;
import cn.edu.lingnan.shop.service.OrderService;
import cn.edu.lingnan.shop.service.ProductService;

/**
 * 商品action
 * 负责和商品有关的数据控制交互
 * @author Administrator
 *
 */

public class ProductAction extends BaseAction {
	
	@Autowired
	protected ProductService productService;
	
	@Autowired
	protected CategoryService categoryService;
	
	@Autowired
	private DownProductService downProductService;
	
	@Autowired
	private OrderService orderService;
	
	private List<Category> cateList;
	
	private List<Product> productList;
	private List<Product> userProductList;
	
	protected List<Product> products;
	protected List<Category> categories;
	 
	private Clothes clothe;
	
	private Product product;
	
	private DownProduct downProduct;
	
	//分页查询的参数
	private int pageNo;
	private static final int PAGESIZE = 4;
	private int prev;
	private int next;
	private int allPages;
	private int pageNo1;
	private int prev1;
	private int next1;
	private int allPages1;
	
	//需要上传的文件，一下三大属性
	private File[] pic;        
	private String[] picContentType;
	private String[] picFileName; 
	
	private int id;
	private int downId;

	protected String keyword;//搜索关键字
	protected String result;//结果
	
	//添加商品中转站，只为显示商品类型下拉框
	public String toAdd(){
		cateList = productService.findAllCates();
		return SUCCESS;
	}

	//添加商品信息
	public String addProduct(){
		try {
			User user = (User) this.session.get("user");
			clothe.setUser(user);
			Long productid = productService.saveClothes(clothe);
			
			product.setCategory(productService.getCateById((long) id));
			product.setId(productid);
			product.setProductdate(new Date());
			product.setUser(user);
//			System.out.println(product.getId());
			product.setOffshelf(0L);
			product.setFromtable(productService.getCateById((long) id).getFromtable());
			
			productService.saveProduct(product);
			
			String path = this.application.getRealPath("upload");
			
			if(pic != null) {
				File deskFile = new File(path);
//				if(!deskFile.getParentFile().exists())
//					deskFile.getParentFile().mkdirs();
//				System.out.println(pic.length);
				for (int i=0;i<pic.length;i++) {
					ProductImages productImages = new ProductImages();
					File saveFile = new File(deskFile,picFileName[i]);
					FileUtils.copyFile(pic[i], saveFile);
					
					productImages.setPath(picFileName[i]);
					productImages.setProduct(productService.getProductById(productid));
					productService.saveImages(productImages);
				}
			}
			
		} catch (IOException e) {
			return ERROR;
		}
		
		return SUCCESS;
	}

	//下架商品
	public String toDelete(){
//		System.out.println(id);
		product = productService.getProductById((long) id);
		product.setOffshelf(1L);
		productService.updateProduct(product);
		
		downProduct = new DownProduct();
		
		downProduct.setDowndate(new Date());
		downProduct.setProduct(product);
		User user = (User) this.session.get("user");
		downProduct.setUserid(user.getId());
		downProduct.setOnshelfdate(null);
		downProduct.setReason(null);
		downProductService.saveDwonProduct(downProduct);
		
		return SUCCESS;
	}
	
	//上架商品
	public String toUpload(){
		System.out.println(downId);
		downProduct = new DownProduct();
		product = productService.getProductById((long) id);
//		if(product.getOffshelf() == 2) {
//			this.request.setAttribute("offset", 2);
//			return ERROR;
//		}
		product.setOffshelf(0L);
		downProduct = downProductService.getDownProductById((long) downId);
		downProduct.setOnshelfdate(new Date());
		downProduct.setDowndate(null);
		downProductService.updateDownProduct(downProduct);
		productService.updateProduct(product);
		return SUCCESS;
	}
	
	//商品加载模块
	public String loadProduct(){
		userProductList = new ArrayList<>();
		productList = new ArrayList<>();
		
		User user = (User) this.session.get("user");
		
//		productList = productService.finaAllProduct();
//		for (Product product : productList) {
//			if (product.getUser() != null && product.getUser().getId() == user.getId()) {
//				userProductList.add(product);
//			}
//		}
		
//		System.out.println(userProductList.size());
//		
		if(pageNo == 0)
			pageNo = 1;
		
		userProductList = productService.getPageById(PAGESIZE, pageNo, user.getId(),0);
		
		Long count = productService.getAllCount(user.getId(),0);
		
		allPages = (int) (count % PAGESIZE == 0 ? count / PAGESIZE : count / PAGESIZE + 1);
		
		if(allPages == 1){
			pageNo = 1;
			prev = pageNo;
			next = pageNo;
		} else {
			prev = pageNo;
			next = pageNo;
		if(pageNo <= 1){
			prev = 1;
			next++;
		} else if(pageNo >= allPages){
			prev--;
			next = allPages;
		} else {
			prev--;
			next++;
		}
		
		}
		
		if(pageNo1 == 0)
			pageNo1 = 1;
		
		productList = productService.getPageById(PAGESIZE, pageNo1, user.getId(),1);
		Long count1 = productService.getAllCount(user.getId(),1);
		
		allPages1 = (int) (count1 % PAGESIZE == 0 ? count1 / PAGESIZE : count1 / PAGESIZE + 1);
		
		if(allPages1 == 1){
			pageNo1 = 1;
			prev1 = pageNo1;
			next1 = pageNo1;
		} else {
			prev1 = pageNo1;
			next1 = pageNo1;
		if(pageNo1 <= 1){
			prev1 = 1;
			next1++;
		} else if(pageNo1 >= allPages1){
			prev1--;
			next1 = allPages1;
		} else {
			prev1--;
			next1++;
		}
		
		}
		return SUCCESS;
	}
	
	//回显商品数据
	public String toUpdate(){
		product = productService.getProductById((long) id);
//		System.out.println(product.getName());
		clothe = productService.getClotheById((long) id);
		return SUCCESS;
	}
	
	//更新商品数据
	public String updateProduct(){
		try {
			
			User user = (User) this.session.get("user");
			product.setUser(user);
			
			productService.updateClothes(clothe);
			
			productService.updateProduct(product);
			
			String path = this.application.getRealPath("upload");
			
			if(pic != null) {
				File deskFile = new File(path);
				if(!deskFile.getParentFile().exists())
					deskFile.getParentFile().mkdirs();
				for (int i=0;i<pic.length;i++) {
					ProductImages productImages = new ProductImages();
					File saveFile = new File(deskFile,picFileName[i]);
					
					if(saveFile.exists())
						saveFile.delete();
					
					File newFile = new File(deskFile,picFileName[i]);
					FileUtils.copyFile(pic[i], newFile);
					
					productImages.setPath(picFileName[i]);
					productImages.setProduct(product);
					productService.saveImages(productImages);
				}
			}
			
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

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public List<Product> getUserProductList() {
		return userProductList;
	}

	public void setUserProductList(List<Product> userProductList) {
		this.userProductList = userProductList;
	}

	public DownProduct getDownProduct() {
		return downProduct;
	}

	public void setDownProduct(DownProduct downProduct) {
		this.downProduct = downProduct;
	}

	public int getDownId() {
		return downId;
	}

	public void setDownId(int downId) {
		this.downId = downId;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPrev() {
		return prev;
	}

	public void setPrev(int prev) {
		this.prev = prev;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getAllPages() {
		return allPages;
	}

	public void setAllPages(int allPages) {
		this.allPages = allPages;
	}

	public int getAllPages1() {
		return allPages1;
	}

	public void setAllPages1(int allPages1) {
		this.allPages1 = allPages1;
	}

	public int getPageNo1() {
		return pageNo1;
	}

	public void setPageNo1(int pageNo1) {
		this.pageNo1 = pageNo1;
	}

	public int getPrev1() {
		return prev1;
	}

	public void setPrev1(int prev1) {
		this.prev1 = prev1;
	}

	public int getNext1() {
		return next1;
	}

	public void setNext1(int next1) {
		this.next1 = next1;
	}



}
