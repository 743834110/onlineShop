package cn.edu.lingnan.shop.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.lingnan.shop.pojo.DownProduct;
import cn.edu.lingnan.shop.pojo.Product;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.service.AdminService;
import cn.edu.lingnan.shop.service.DownProductService;
import cn.edu.lingnan.shop.service.ProductService;
import cn.edu.lingnan.shop.service.UserService;

/**
 * 管理员action
 * 负责和管理员登陆有关的数据控制
 * @author 刘瑜
 *
 */

public class AdminAction extends BaseAction {
	
	@Autowired
	private UserService userService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private ProductService productService;
	@Autowired
	private DownProductService downProductService;
	
	
	private User adminlogin;//表单提交数据的对象
	private List<User> commonUser;	//普通用户列表
	private List<Product> productList;	//商品列表
	private int productflag;	//商品状态：1:上架 , 2:下架
	private Map<String, Object> data = new HashMap<String, Object>();
	
	/***
	 * 账号密码的验证
	 */
	public String login(){
		User loginAdmin = userService.login(adminlogin);
		if (loginAdmin != null) {
			if (loginAdmin.getType()==null || loginAdmin.getType() != 3){
				super.addActionMessage("您不是管理员");
				return ERROR;
			}
			//保存用户对象到session当中
			this.session.put("admin", loginAdmin);
			return SUCCESS;
		} else {//失效--->login.jsp，并提示
			super.addActionMessage("用户名或密码错误！");
			return ERROR;
		}
	}
	
	/***
	 * 管理员登录时的判断验证码是否正确
	 * @return
	 */
	public void validateLogin(){
		if (adminlogin.getUsername()!=null && adminlogin.getUsername().trim().equals(""))
			super.addFieldError("username", "The username is not allowed to be empty.");
		if (adminlogin.getPassword()!=null && adminlogin.getPassword().trim().equals(""))
			super.addFieldError("password", "The password is not allowed to be empty.");
	}
	
	/***
	 * 注销管理员的登录,即管理员退出登录
	 * @return
	 */
	public String logout(){
		//this.session.put("admin", null);
		this.request.getSession().invalidate();
		return SUCCESS;
	}
	
	/**
	 * 加载普通用户
	 */
	public String loadCommonUser() {
		commonUser = adminService.findAllCommonUser();
		return SUCCESS;
	}
	
	/**
	 * 加载上架的商品
	 */
	public String loadSellProduct() {
		productList = adminService.findAllSellProduct();
		productflag = 1;
		return SUCCESS;
	}
	
	/**
	 * 加载管理员下架的商品
	 * @return
	 */
	public String loadnoSellProduct() {
		productList = adminService.findAllNoSellProduct();
		productflag = 2 ;
		return SUCCESS;
	}
	
	/**
	 * 管理员下架商品
	 */
	public String toNoSellProduct() {
		long id = Long.parseLong(this.request.getParameter("id"));
		Product product = productService.getProductById(id);
		product.setOffshelf(2L);
		productService.updateProduct(product);
		//下架商品表添加一条记录
		DownProduct downProduct = new DownProduct();
		String reason = this.request.getParameter("reason");
		downProduct.setDowndate(new Date());
		downProduct.setReason(reason);
		downProduct.setProduct(product);
		User user = (User) this.session.get("admin");
		downProduct.setUserid(user.getId());
		downProductService.saveDwonProduct(downProduct);
		data.put("success", "成功");
		return SUCCESS;
	}
	
	/**
	 * 管理员上架商品
	 * @return
	 */
	public String toSellProduct() {
		long id = Long.parseLong(this.request.getParameter("id"));
		Product product = productService.getProductById(id);
		DownProduct downProduct = product.getDownProducts().get(0);
		downProduct.setOnshelfdate(new Date());
		downProduct.setDowndate(null);
		downProductService.updateDownProduct(downProduct);
		product.setOffshelf(0L);
		productService.updateProduct(product);
		data.put("success", "成功");
		return SUCCESS;
	}
	
	//getter and setter 
	public User getAdminlogin() {
		return adminlogin;
	}

	public void setAdminlogin(User adminlogin) {
		this.adminlogin = adminlogin;
	}

	public List<User> getCommonUser() {
		return commonUser;
	}

	public void setCommonUser(List<User> commonUser) {
		this.commonUser = commonUser;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public int getProductflag() {
		return productflag;
	}

	public void setProductflag(int productflag) {
		this.productflag = productflag;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
}
