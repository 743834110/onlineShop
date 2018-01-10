package cn.edu.lingnan.shop.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.lingnan.shop.pojo.Address;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.service.AddressService;
import cn.edu.lingnan.shop.service.UserService;

public class AddressAction extends BaseAction {
	
	@Autowired
	private AddressService addressService;

	
	private List<Address> addresslist;	//收货地址列表
	//分页参数
	private	int pageNo;
	private final int PAGESIZE = 5;
	private int nextpage;
	private int prevpage;
	private int allpage;
	private long allCount;
	//添加收货地址对象, 编辑收货地址对象
	private Address address;
	//删除收货地址的id
	private long addressid;
	
	//前往管理收货地址页面
	public String toaddress() {
		if (pageNo <= 0)
			pageNo = 1;
		User user = (User) this.session.get("user");
		Address address = new Address();
		address.setUser(user);
		
		addresslist = addressService.getAddressByPage(pageNo, PAGESIZE, address);
		allCount = addressService.getAddressCount(address);
		
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
	
	//增加收货地址
	public String saveaddress() {
		address.setUser( (User) this.session.get("user"));
		addressService.saveAddress(address);
		return SUCCESS;
	}
	
	//增加收货地址对地址数据的验证
	public void validateSaveaddress() {
		if (address.getUsername()==null && address.getUsername().trim().equals(""))
			super.addFieldError("address.username", "收货人不能为空");
		if (address.getTelephone()==null && address.getTelephone().trim().equals(""))
			super.addFieldError("address.telephone", "联系电话不能为空");
		if (address.getExtra()==null && address.getExtra().trim().equals(""))
			super.addFieldError("address.extra", "详细地址不能为空");
	}
	
	//删除一个收货地址
	public String deleteAddress() {
		addressService.deleteAddress(addressService.getAddresById(addressid));
		return SUCCESS;
	}
	
	//前往编辑收货地址页面
	public String toUpdateAddress() {
		address = addressService.getAddresById(addressid);
		return SUCCESS;
	}
	
	public String updateAddress() {
		address.setUser( (User) this.session.get("user"));
		addressService.updateAddress(address);
		return SUCCESS;
	}

	
	//getter and setter
	public List<Address> getAddresslist() {
		return addresslist;
	}
	public long getAddressid() {
		return addressid;
	}
	public void setAddressid(long addressid) {
		this.addressid = addressid;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public long getAllCount() {
		return allCount;
	}
	public void setAllCount(long allCount) {
		this.allCount = allCount;
	}
	public void setAddresslist(List<Address> addresslist) {
		this.addresslist = addresslist;
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
	public int getPAGESIZE() {
		return PAGESIZE;
	}
	
}
