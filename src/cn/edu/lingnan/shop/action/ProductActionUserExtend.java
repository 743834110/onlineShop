package cn.edu.lingnan.shop.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import cn.edu.lingnan.shop.pojo.Product;
import cn.edu.lingnan.shop.pojo.ProductExtend;

public class ProductActionUserExtend extends ProductAction{
	//分页
	private int next;
	private int prev;
	private int current;
	private int allCount;
	private int allPages;
	private ProductExtend product;
	

	private int limitSize = 2;
	/**
	 * json信息获取
	 * @return
	 */
	public String getProductToJSON(){
		
		System.out.println(this.keyword);
		List<String> names = this.productService
				.getProductByNameWithLimit(keyword, limitSize);
		
		JSONArray array = JSONArray.fromObject(names);
		this.result = array.toString();
		return SUCCESS;
	}
	/**
	 * 呈现商品到list.jsp页面
	 * @return
	 */
	public String listProducts(){
		this.products = this.productService.getProductByName(keyword, limitSize);
		List<Long> ids = new ArrayList<Long>();
		for (Product product: this.products){
			System.out.println(product.getCategory().getId());
			ids.add(product.getCategory().getId());
		}
		this.categories = this.categoryService.getCategoriesByIds(ids);
		return SUCCESS;
	}
	
	/**
	 * 组合查询的搜索
	 * @return
	 */
	public String condSearch(){
		
		
		return SUCCESS;
	}
	
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getPrev() {
		return prev;
	}
	public void setPrev(int prev) {
		this.prev = prev;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public int getAllCount() {
		return allCount;
	}
	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}
	public int getAllPages() {
		return allPages;
	}
	public void setAllPages(int allPages) {
		this.allPages = allPages;
	}
	public ProductExtend getProduct() {
		return product;
	}
	public void setProduct(ProductExtend product) {
		this.product = product;
	}
	
}
