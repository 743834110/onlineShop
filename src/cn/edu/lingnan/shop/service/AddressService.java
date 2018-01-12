package cn.edu.lingnan.shop.service;

import java.util.List;

import cn.edu.lingnan.shop.pojo.Address;
import cn.edu.lingnan.shop.pojo.User;

public interface AddressService {
	
	public List<Address> getAddressByPage(int pageNo, int pageSize, User user);
	public long getAddressCount(User address);
	public void saveAddress(Address address);
	public void deleteAddress(Address address);
	public Address getAddresById(long id);
	public void updateAddress(Address address);
	public List<Address> getAddressAll(User user);
}
