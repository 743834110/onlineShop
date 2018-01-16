package cn.edu.lingnan.shop.action;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.lingnan.shop.pojo.Category;
import cn.edu.lingnan.shop.pojo.Comments;
import cn.edu.lingnan.shop.pojo.DownProduct;
import cn.edu.lingnan.shop.pojo.Product;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.pojo.UserOrder;
import cn.edu.lingnan.shop.service.AdminIndexService;
import cn.edu.lingnan.shop.service.AdminService;
import cn.edu.lingnan.shop.service.CategoryService;
import cn.edu.lingnan.shop.service.CommentService;
import cn.edu.lingnan.shop.service.DownProductService;
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
	@Autowired
	private AdminIndexService adminIndexService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private DownProductService downProductService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private OrderService userOrderService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private AdminService adminService;
	
	private int productflag; //商品状态：1.上架，2.下架
	private Map<String, Object> data = new HashMap<String, Object>();
	
	private User user;
	private Category category;
	private Product product;
	private UserOrder userOrder;
	private DownProduct downProduct;
	
	private List<User> userList;
	private List<Category> categoryList;
	private List<Product> productList;
	private List<UserOrder> userOrderList;
	private List<DownProduct> downProductList;
	private List<Comments> commentsList;
	
	private int prev;//前一页
	private int next;//后一页
	private int userCounts;//用户总记录数
	private int categoryCounts;//商品种类总记录数
	private int productCounts;//商品总记录数
	private int userOrderCounts;//订单总记录数
	private int downProductCounts;//下架商品总记录数
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
	private User adminIndexExample;
	private Comments commentsExample;
	
//	//详情数据
//	private User userDetail;
//	private Category categoryDetail;
//	private Product productDetail;
//	private UserOrder userOrderDetail;
//	private DownProduct downProductDetail;
	
//	//文件数据
//	private File pic;
//	private String picContentType;
//	private String picFileName;
	
	//定义接收的id值
	private int userId;
	private int categoryId;
	private int productId;
	private int userOrderId;
	private int downProductId;
	private int updatePage;
	private int commentsId;
	
	//错误消息提示
	private String message;
	
	/**
	 * 加载普通用户
	 */
	public String loadUser() {
		userList = adminIndexService.findAllUser();
		return SUCCESS;
	}
	
	/**
	 * 加载上架的商品
	 */
	public String loadOnsellProduct() {
		productList = adminIndexService.findAllOnsellProduct();
		productflag = 1;
		return SUCCESS;
	}
	
	/**
	 * 加载管理员下架的商品
	 * @return
	 */
	public String loadOffsellProduct() {
		productList = adminIndexService.findAllOffsellProduct();
		productflag = 2 ;
		return SUCCESS;
	}
	
	/**
	 * 管理员下架商品
	 */
	public String toOffsellProduct() {
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
	public String toOnsellProduct() {
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
	
	/**
	 * 加载评论信息
	 */
	public String loadComments() {
		commentsList = adminIndexService.findAllComments();
		return SUCCESS;
	}
	
	/**
	 * 加载商品种类数目
	 * @return
	 */
	public String loadCategory(){
		categoryList = adminIndexService.findAllCategory();
		return SUCCESS;
	}
	
	/**
	 * 加载订单信息
	 * @return
	 */
	public String loadUserOrder(){
		userOrderList = adminIndexService.findAllUserOrder();
		return SUCCESS;
	}
	
	
	//读取某用户的信息
//	public String loadUser(){
//		this.userExample = this.adminIndexService.getUser(userId);//如此可否
//		return SUCCESS;
//	}
//	
	//读取所有用户的信息
	public String loadUsers(){
		if(this.pageNo == 0)
			pageNo = 1;
		this.userList = (List<User>) this.adminIndexService.
				loadUsers(PAGESIZE,this.pageNo,this.userExample);
		this.userCounts = (int) this.adminIndexService.loadUsersCount(this.userExample);
		this.prev = this.pageNo - 1;
		this.next = this.pageNo + 1;
		long temp = this.userCounts % PAGESIZE;
		this.allPages = temp == 0? this.userCounts / PAGESIZE : this.userCounts / PAGESIZE + 1;
		this.prev = this.prev == 0 ? 1 : this.prev;
		this.next = this.next > this.allPages ? this.allPages : this.next;
		return SUCCESS;
	}
	
	
	//读取某商品的信息
	public String loadProduct(){
		this.productExample = this.adminIndexService.getProduct(productId);
		return SUCCESS;
	}

	//以分页的形式读取商品信息
	public String loadProducts(){
		if(this.pageNo == 0)
			pageNo = 1;
		this.productList = this.adminIndexService.
				loadProduct(PAGESIZE,this.pageNo,this.productExample );
		this.productCounts = (int) this.adminIndexService.loadProductsCount(this.productExample);
		this.prev = this.pageNo - 1;
		this.next = this.pageNo + 1;
		long temp = this.userCounts % PAGESIZE;
		this.allPages = temp == 0? this.userCounts / PAGESIZE : this.userCounts / PAGESIZE + 1;
		this.prev = this.prev == 0 ? 1 : this.prev;
		this.next = this.next > this.allPages ? this.allPages : this.next;
		return SUCCESS;
	}
	
	//加载管理员页面
	public String loadAdminIndex(){
		this.adminIndexExample = this.adminIndexService.getUser(userId);
		return SUCCESS;
	}
	
	//读取商品分类信息
//	public String loadCategory(){
//		this.categoryExample = this.adminIndexService.getCategory(categoryId);
//		return SUCCESS;
//	}
//	
	//读取商品评论信息
//	public String loadComments(){
//		this.commentsExample = this.adminIndexService.getComments(commentsId);
//		return SUCCESS;
//	}
//	
	
	//申请卖家审核
	
	
	//订单信息管理
//	public String loadUserOrder(){
//		this.userOrderExample = this.adminIndexService.getUserOrder(userOrderId);
//		return SUCCESS;
//	}
	

	
	//getter and setter
	public User getAdminIndexExample() {
		return adminIndexExample;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public List<Comments> getCommentsList() {
		return commentsList;
	}

	public void setCommentsList(List<Comments> commentsList) {
		this.commentsList = commentsList;
	}

	public int getUserCounts() {
		return userCounts;
	}

	public void setUserCounts(int userCounts) {
		this.userCounts = userCounts;
	}

	public int getCategoryCounts() {
		return categoryCounts;
	}

	public void setCategoryCounts(int categoryCounts) {
		this.categoryCounts = categoryCounts;
	}

	public int getProductCounts() {
		return productCounts;
	}

	public void setProductCounts(int productCounts) {
		this.productCounts = productCounts;
	}

	public int getUserOrderCounts() {
		return userOrderCounts;
	}

	public void setUserOrderCounts(int userOrderCounts) {
		this.userOrderCounts = userOrderCounts;
	}

	public int getDownProductCounts() {
		return downProductCounts;
	}

	public void setDownProductCounts(int downProductCounts) {
		this.downProductCounts = downProductCounts;
	}

	public void setAdminIndexExample(User adminIndexExample) {
		this.adminIndexExample = adminIndexExample;
	}

	public Comments getCommentsExample() {
		return commentsExample;
	}

	public void setCommentsExample(Comments commentsExample) {
		this.commentsExample = commentsExample;
	}

	public int getCommentsId() {
		return commentsId;
	}

	public void setCommentsId(int commentsId) {
		this.commentsId = commentsId;
	}

	public List<User> getUserList() {
		return userList;
	}
	public DownProduct getDownProduct() {
		return downProduct;
	}

	public void setDownProduct(DownProduct downProduct) {
		this.downProduct = downProduct;
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
//	public User getUserDetail() {
//		return userDetail;
//	}
//	public void setUserDetail(User userDetail) {
//		this.userDetail = userDetail;
//	}
//	public Category getCategoryDetail() {
//		return categoryDetail;
//	}
//	public void setCategoryDetail(Category categoryDetail) {
//		this.categoryDetail = categoryDetail;
//	}
//	public Product getProductDetail() {
//		return productDetail;
//	}
//	public void setProductDetail(Product productDetail) {
//		this.productDetail = productDetail;
//	}
//	public UserOrder getUserOrderDetail() {
//		return userOrderDetail;
//	}
//	public void setUserOrderDetail(UserOrder userOrderDetail) {
//		this.userOrderDetail = userOrderDetail;
//	}
//	public DownProduct getDownProductDetail() {
//		return downProductDetail;
//	}
//	public void setDownProductDetail(DownProduct downProductDetail) {
//		this.downProductDetail = downProductDetail;
//	}
//	public File getPic() {
//		return pic;
//	}
//	public void setPic(File pic) {
//		this.pic = pic;
//	}
//	public String getPicContentType() {
//		return picContentType;
//	}
//	public void setPicContentType(String picContentType) {
//		this.picContentType = picContentType;
//	}
//	public String getPicFileName() {
//		return picFileName;
//	}
//	public void setPicFileName(String picFileName) {
//		this.picFileName = picFileName;
//	}
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
