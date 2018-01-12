package cn.edu.lingnan.shop.action;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.lingnan.shop.pojo.Category;
import cn.edu.lingnan.shop.pojo.DownProduct;
import cn.edu.lingnan.shop.pojo.Product;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.pojo.UserOrder;
import cn.edu.lingnan.shop.service.OrderService;
import cn.edu.lingnan.shop.service.ProductService;
import cn.edu.lingnan.shop.service.UserService;

/**
 * 管理员主页加载页面action
 * @author 刘瑜
 *
 */
public class AdminIndexAction extends BaseAction {
	
	//访问量，有多少个注册用户，订单量，商品量
	
	@Autowired  //绑定
	private UserService userService;
	private User user;
	private Category category;
	private ProductService productService;
	private Product product;
	private OrderService userOrderService;
	private UserOrder userOrder;
	private DownProduct downProduct;
	
	private List<User> userList;
	private List<Category> categoryList;
	private List<Product> productList;
	private List<UserOrder> userOrderList;
	private List<DownProduct> downProductList;
	
	private int prev;//前一页
	private int next;//后一页
	private int allCounts;//总记录数
	private int allPages;//总页数
	private int pageNo;//当前页数
	
	//每页记录数
	private static final int PAGESIZE=5;
	
	//组合查询条件的封装对象
	private User userExample;
	private Category categoryExample;
	private Product productExample;
	private UserOrder userOrderExample;
	private DownProduct downProductExample;
	
	//详情数据
	private User userDetail;
	private Category categoryDetail;
	private Product productDetail;
	private UserOrder userOrderDetail;
	private DownProduct downProductDetail;
	
	//文件数据
	private File pic;
	private String picContentType;
	private String picFileName;
	
	//定义接收的id值
	private int userId;
	private int categoryId;
	private int productId;
	private int userOrderId;
	private int downProductId;
	
	private int updatePage;
	
	//错误消息提示
	private String message;
	
	
	
	
	
	
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public List<UserOrder> getUserOrderList() {
		return userOrderList;
	}
	public void setUserOrderList(List<UserOrder> userOrderList) {
		this.userOrderList = userOrderList;
	}
	public List<DownProduct> getDownProductList() {
		return downProductList;
	}
	public void setDownProductList(List<DownProduct> downProductList) {
		this.downProductList = downProductList;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
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
	public int getAllCounts() {
		return allCounts;
	}
	public void setAllCounts(int allCounts) {
		this.allCounts = allCounts;
	}
	public int getAllPages() {
		return allPages;
	}
	public void setAllPages(int allPages) {
		this.allPages = allPages;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public User getUserExample() {
		return userExample;
	}
	public void setUserExample(User userExample) {
		this.userExample = userExample;
	}
	public Category getCategoryExample() {
		return categoryExample;
	}
	public void setCategoryExample(Category categoryExample) {
		this.categoryExample = categoryExample;
	}
	public Product getProductExample() {
		return productExample;
	}
	public void setProductExample(Product productExample) {
		this.productExample = productExample;
	}
	public UserOrder getUserOrderExample() {
		return userOrderExample;
	}
	public void setUserOrderExample(UserOrder userOrderExample) {
		this.userOrderExample = userOrderExample;
	}
	public DownProduct getDownProductExample() {
		return downProductExample;
	}
	public void setDownProductExample(DownProduct downProductExample) {
		this.downProductExample = downProductExample;
	}
	public User getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(User userDetail) {
		this.userDetail = userDetail;
	}
	public Category getCategoryDetail() {
		return categoryDetail;
	}
	public void setCategoryDetail(Category categoryDetail) {
		this.categoryDetail = categoryDetail;
	}
	public Product getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(Product productDetail) {
		this.productDetail = productDetail;
	}
	public UserOrder getUserOrderDetail() {
		return userOrderDetail;
	}
	public void setUserOrderDetail(UserOrder userOrderDetail) {
		this.userOrderDetail = userOrderDetail;
	}
	public DownProduct getDownProductDetail() {
		return downProductDetail;
	}
	public void setDownProductDetail(DownProduct downProductDetail) {
		this.downProductDetail = downProductDetail;
	}
	public File getPic() {
		return pic;
	}
	public void setPic(File pic) {
		this.pic = pic;
	}
	public String getPicContentType() {
		return picContentType;
	}
	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}
	public String getPicFileName() {
		return picFileName;
	}
	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserOrderId() {
		return userOrderId;
	}
	public void setUserOrderId(int userOrderId) {
		this.userOrderId = userOrderId;
	}
	public int getDownProductId() {
		return downProductId;
	}
	public void setDownProductId(int downProductId) {
		this.downProductId = downProductId;
	}
	public int getUpdatePage() {
		return updatePage;
	}
	public void setUpdatePage(int updatePage) {
		this.updatePage = updatePage;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public UserOrder getUserOrder() {
		return userOrder;
	}
	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}
}
