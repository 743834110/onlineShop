package cn.edu.lingnan.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.lingnan.shop.dao.AddressDao;
import cn.edu.lingnan.shop.pojo.Address;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.service.AddressService;

@Transactional
@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressDao addressdao;

	
	/**
	 * 获取用户的收藏地址，分页显示
	 * @author huang
	 * @param pageNo 页码
	 * @param pageSize 每页显示数
	 * @return List<Address> 收藏地址集合
	 */
	@Override
	public List<Address> getAddressByPage(int pageNo, int pageSize, User user) {
		String hql = "select a from Address a where user = ?";
		List<Address> list = addressdao.queryListObjectAllForPage(pageSize, pageNo, hql, user);
		return list;
	}

	/**
	 * 获取用户收藏地址数量
	 * @author huang
	 * @return long 用户收藏地址数量
	 */
	@Override
	public long getAddressCount(User address) {
		String hql = "select count(a) from Address a where user = ?";
		return (long) addressdao.uniqueResult(hql, address);
	}

	/**
	 * 用户增加一个收货地址
	 * @author huang
	 * @param address 收货地址对象
	 */
	@Override
	public void saveAddress(Address address) {
		addressdao.save(address);
	}

	
	/**
	 * 用户删除一个收货地址
	 * @author huang
	 * @param address 收货地址对象
	 */
	@Override
	public void deleteAddress(Address address) {
		addressdao.delete(address);
	}

	/**
	 * 根据收货地址id得到收货地址对象
	 * @author huang
	 * @param id 收货地址id
	 * @return Address 收货地址对象
	 */
	@Override
	public Address getAddresById(long id) {
		return addressdao.findById(id);
	}

	/**
	 * 修改用户收货地址
	 * @author huang
	 * @param address 修改的收货地址对象
	 */
	@Override
	public void updateAddress(Address address) {
		addressdao.update(address);
	}

	/**
	 * 获取用户所有收货地址
	 * @author huang
	 * @param user 用户
	 */
	@Override
	public List<Address> getAddressAll(User user) {
		String hql = "select a from Address a where user = ?";
		return addressdao.getListByHQL(hql, user);
	}
	
	

}
