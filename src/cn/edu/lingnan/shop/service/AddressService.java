package cn.edu.lingnan.shop.service;

import java.util.List;

import cn.edu.lingnan.shop.pojo.Address;

public interface AddressService {
	
	public List<Address> getAddressByPage(int pageNo, int pageSize, Address address);
	public long getAddressCount(Address address);
	public void saveAddress(Address address);
	public void deleteAddress(Address address);
	public Address getAddresById(long id);
	public void updateAddress(Address address);
}
