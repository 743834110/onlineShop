package cn.edu.lingnan.shop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.lingnan.shop.dao.AddressDao;
import cn.edu.lingnan.shop.pojo.Address;
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
	public List<Address> getAddressByPage(int pageNo, int pageSize) {
		String hql = "select a from Address a";
		List<Address> list = addressdao.queryListObjectAllForPage(pageSize, pageNo, hql);
		return list;
	}

	/**
	 * 获取用户收藏地址数量
	 * @author huang
	 * @return long 用户收藏地址数量
	 */
	@Override
	public long getAddressCount() {
		String hql = "select count(a) from Address a";
		return (long) addressdao.uniqueResult(hql);
	}
	
	

}
