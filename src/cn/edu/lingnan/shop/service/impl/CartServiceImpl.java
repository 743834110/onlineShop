package cn.edu.lingnan.shop.service.impl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.lingnan.shop.dao.CartDao;
import cn.edu.lingnan.shop.dao.ProductDao;
import cn.edu.lingnan.shop.dao.UserOrderDao;
import cn.edu.lingnan.shop.pojo.Cart;
import cn.edu.lingnan.shop.pojo.CartExample;
import cn.edu.lingnan.shop.pojo.Product;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.service.CartService;

@Transactional
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartdao;
	@Autowired
	private ProductDao productDao;
	/**
	 * 根据用户获取购物车信息
	 * @author huang
	 * @param user 用户对象
	 * @return List<CartExample> 购物车扩展类列表
	 */
	@Override
	public List<CartExample> getAllCart(User user) {
		String hql = "select c from Cart c where user = ?";
		List<Cart> cartlist = cartdao.getListByHQL(hql, user);
		List<CartExample> exampleList = new ArrayList<CartExample>();
		for (Cart cart : cartlist) {
			CartExample c = new CartExample(cart);
			exampleList.add(c);
		}
		return exampleList;
	}

	/**
	 * 根据购物车Id，给商品数量+1
	 * @author huang
	 * @param id 购物车id
	 * @throws Exception 
	 */
	@Override
	public void addCartNumber(long id){
		Cart cart = cartdao.findById(id);
		long number = cart.getNum() + 1L;
		cart.setNum(number);
		cartdao.update(cart);
	}

	/**
	 * 根据购物车Id，给商品数量-1
	 * @author huang
	 * @param id 购物车id
	 */
	@Override
	public void declineCartNumber(long id) {
		Cart cart = cartdao.findById(id);
		long number = cart.getNum() - 1L;
		cart.setNum(number);
		cartdao.update(cart);
	}

	/**
	 * 根据一个id数组得到一个购物车列表
	 * @author huang
	 * @param id 购物车id数组
	 * @return List<CartExample> 购物车列表
	 */
	@Override
	public List<CartExample> getCartByIdArray(long[] id) {
		if(id == null)
			return null;
		List<CartExample> list = new ArrayList<CartExample>();
		for(long i : id) {
			Cart cart = cartdao.findById(i);
			list.add(new CartExample(cart));
		}
		return list;
	}

	/**
	 * 根据购物车id获取购物车
	 * @author huang
	 * @param id 购物车id
	 * @return Cart 购物车对象
	 */
	@Override
	public Cart findCartById(long id) {
		return cartdao.findById(id);
	}

	/**
	 * 删除购物车内容
	 * @author huang
	 * @param cart 要删除的购物车
	 */
	@Override
	public void deleteCart(Cart cart) {
		cartdao.delete(cart);
	}


	/**
	 * 添加或者购物车中的内容清单
	 * @author li
	 * 
	 */
	@Override
	public void mergeCart(Cart cart) {
		// TODO Auto-generated method stub
		this.cartdao.merge(cart);
	}

	//查看是否有相类似的收藏,有则返回相应的id没有就返回0
	@Override
	public Serializable isTheSameProductInCart(Cart cart) {
		List<Cart> carts = this.cartdao.find(cart);
		if (carts == null || carts.size() == 0)
			return 0;
		return carts.get(0).getId();
	}
	@Override
	public void deleteProductSurplus(Cart cart) {
		Product product = cart.getProduct();
		long num = product.getSurplus() - cart.getNum();
		product.setSurplus(num);
		productDao.update(product);
	}

}
