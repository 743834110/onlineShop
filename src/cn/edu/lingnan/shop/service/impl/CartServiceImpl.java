package cn.edu.lingnan.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.lingnan.shop.dao.CartDao;
import cn.edu.lingnan.shop.pojo.Cart;
import cn.edu.lingnan.shop.pojo.CartExample;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.service.CartService;

@Transactional
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartdao;
	
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

}
