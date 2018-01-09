package cn.edu.lingnan.shop.service;

import java.util.List;

import cn.edu.lingnan.shop.pojo.Address;

public interface AddressService {
	
	public List<Address> getAddressByPage(int pageNo, int pageSize);
	public long getAddressCount();

}
