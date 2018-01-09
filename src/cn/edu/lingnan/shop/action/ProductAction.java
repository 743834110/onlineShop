package cn.edu.lingnan.shop.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.lingnan.shop.pojo.Category;
import cn.edu.lingnan.shop.service.ProductService;

/**
 * 商品action
 * 负责和商品有关的数据控制交互
 * @author Administrator
 *
 */

public class ProductAction extends BaseAction {
	
	@Autowired
	private ProductService cateService;
	
	private List<Category> cateList;
	
	public String toAdd(){
		cateList = cateService.findAllCates();
		return SUCCESS;
	}

	public List<Category> getCateList() {
		return cateList;
	}

	public void setCateList(List<Category> cateList) {
		this.cateList = cateList;
	}
	
	
	
}
