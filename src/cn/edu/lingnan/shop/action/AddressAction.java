package cn.edu.lingnan.shop.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.lingnan.shop.pojo.Address;
import cn.edu.lingnan.shop.service.AddressService;

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
	
	//前往管理收货地址页面
	public String toaddress() {
		if (pageNo <= 0)
			pageNo = 1;
		
		addresslist = addressService.getAddressByPage(pageNo, PAGESIZE);
		allCount = addressService.getAddressCount();
		
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

	
	//getter and setter
	public List<Address> getAddresslist() {
		return addresslist;
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
