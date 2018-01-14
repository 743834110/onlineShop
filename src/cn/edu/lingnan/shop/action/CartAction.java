package cn.edu.lingnan.shop.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.lingnan.shop.pojo.Address;
import cn.edu.lingnan.shop.pojo.Cart;
import cn.edu.lingnan.shop.pojo.CartExample;
import cn.edu.lingnan.shop.pojo.Product;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.pojo.UserOrder;
import cn.edu.lingnan.shop.service.AddressService;
import cn.edu.lingnan.shop.service.CartService;
import cn.edu.lingnan.shop.service.OrderService;
import cn.edu.lingnan.shop.service.UserService;

/**
 * 购物车action
 * 负责和购物车和商品的交互有关的数据控制
 * @author Administrator
 *
 */
public class CartAction extends BaseAction {
	
	@Autowired
	private CartService cartService;
	@Autowired
	private UserService userService;//用于测试
	@Autowired
	private AddressService addressService;
	@Autowired
	private OrderService orderService;
	
	private List<CartExample> cartList;	//购物车列表
	private long cartId;	//增加和减少商品数量的商品id
	private double allprice;//购物车列表总价钱
	private long[] chooseproduct;	//购物车Id数组
	private List<Long> payproduct = new ArrayList<Long>();	//支付的商品
	//收货地址
	private List<Address> addressList;//分页参数
	private	int pageNo;
	private final int PAGESIZE = 5;
	private int nextpage;
	private int prevpage;
	private int allpage;
	private long allCount;
	
	private Map<String, Object> data = new HashMap<String, Object>();
	private Address address;
	private List<String> orderList = new ArrayList<String>();
	
	/**
	 *	前往购物车页面 
	 */
	public String toCart() {
		User user = (User) this.session.get("user");
		cartList = cartService.getAllCart(user);
		return SUCCESS;
	}
	
	/**
	 * 同步网页添加购物车商品的数量
	 * @return
	 */
	public String addCartNumber() {
		cartService.addCartNumber(cartId);
		return SUCCESS;
	}
	
	/**
	 * 同步网页减少数据库购物车商品的数量
	 * @return
	 */
	public String declineCartNumber() {
		cartService.declineCartNumber(cartId);
		return SUCCESS;
	}
	
	/**
	 * 前往支付页面
	 * @return
	 */
	public String toPay() {
		if (chooseproduct == null) 
			chooseproduct = (long[]) this.session.get("chooseproduct");
		 else 
			 this.session.put("chooseproduct", chooseproduct);
		cartList = cartService.getCartByIdArray(chooseproduct);
		allprice = 0.00;
		for (CartExample cartExample : cartList) {
			Product product = cartExample.getCart().getProduct();
			allprice += product.getPrice() * cartExample.getCart().getNum() + product.getOginprice();
		}
		User user = (User) this.session.get("user");
		if (pageNo <= 0)
			pageNo = 1;
			
		addressList = addressService.getAddressByPage(pageNo, PAGESIZE, user);
		allCount = addressService.getAddressCount(user);
				
		if (allCount % PAGESIZE == 0)
			allpage = (int) allCount / PAGESIZE;
		else 
			allpage = (int) allCount / PAGESIZE + 1;
				
		nextpage = pageNo;
		prevpage = pageNo;
			
		if (pageNo <= 1) {
			if (pageNo != allpage)
				nextpage++;
			else 
				nextpage = 1;
			prevpage=1;
		} else if (pageNo >= allpage) {
			nextpage = allpage;
			prevpage--;
		} else {
			nextpage++;
			prevpage--;
		}
		return SUCCESS;
	}
	
	
	/**
	 * 用户在购物车支付界面添加收货地址
	 * @return
	 */
	public String addAddress() {
		Address addre = new Address();
		addre.setExtra(this.request.getParameter("extra"));
		addre.setTelephone(this.request.getParameter("telephone"));
		addre.setUsername(this.request.getParameter("username"));
		addre.setUser((User) this.session.get("user"));
		String postcode = this.request.getParameter("postcode");
		if(!postcode.equals("null")) 
			addre.setPostcode(postcode);
		addressService.saveAddress(addre);
		data.put("flag", "成功");
		return SUCCESS;
	}
	
	/**
	 * 用户支付生成订单
	 * @return
	 */
	public String mypay() {
		for (long cartid : payproduct) {
			Cart cart = cartService.findCartById(cartid);
			User user = (User) this.session.get("user");
			//address对象只有属性id有值
			String s = orderService.saveUserOreder(cart, address, user);
			orderList.add(s);
			//订单生成后删除购物车的内容
			cartService.deleteCart(cart);
			//订单生成后删除对应库存
			cartService.deleteProductSurplus(cart);
		}
		return SUCCESS;
	}
	
	/**
	 * 支付成功返回商品首页
	 */
	public String paySuccessToIndex() {
		for (String str : orderList) {
			UserOrder userorder = orderService.findOrderByOrdernum(str);
			userorder.setValid(null);
			userorder.setStatus(2);
			orderService.updateOrder(userorder);
		}
		return SUCCESS;
	}
	
	/**
	 * 删除购物车中的商品
	 * @return
	 */
	public String deleteCart() {
		String cartid = this.request.getParameter("id");
		long id = Long.parseLong(cartid);
		cartService.deleteCart(cartService.findCartById(id));
		return SUCCESS;
	}

	//getter and setter
	public List<CartExample> getCartList() {
		return cartList;
	}
	public void setCartList(List<CartExample> cartList) {
		this.cartList = cartList;
	}
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public double getAllprice() {
		return allprice;
	}
	public void setAllprice(double allprice) {
		this.allprice = allprice;
	}
	public long[] getChooseproduct() {
		return chooseproduct;
	}
	public void setChooseproduct(long[] chooseproduct) {
		this.chooseproduct = chooseproduct;
	}
	public List<Long> getPayproduct() {
		return payproduct;
	}
	public void setPayproduct(List<Long> payproduct) {
		this.payproduct = payproduct;
	}
	public List<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getNextpage() {
		return nextpage;
	}

	public void setNextpage(int nextpage) {
		this.nextpage = nextpage;
	}

	public int getPrevpage() {
		return prevpage;
	}

	public void setPrevpage(int prevpage) {
		this.prevpage = prevpage;
	}

	public int getAllpage() {
		return allpage;
	}

	public void setAllpage(int allpage) {
		this.allpage = allpage;
	}

	public long getAllCount() {
		return allCount;
	}

	public void setAllCount(long allCount) {
		this.allCount = allCount;
	}

	public int getPAGESIZE() {
		return PAGESIZE;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<String> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<String> orderList) {
		this.orderList = orderList;
	}

	

}
