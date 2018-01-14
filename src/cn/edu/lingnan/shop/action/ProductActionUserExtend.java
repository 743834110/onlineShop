package cn.edu.lingnan.shop.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import net.sf.json.JSONArray;
import cn.edu.lingnan.shop.pojo.Clothes;
import cn.edu.lingnan.shop.pojo.Product;
import cn.edu.lingnan.shop.pojo.ProductExtend;
import cn.edu.lingnan.shop.service.ClothesService;

public class ProductActionUserExtend extends ProductAction{
	//分页
	private int next;//下一页
	private int prev;//上一页
	private int current;//当前一页面
	private int allCount;//总记录数
	private int allPages;//总页数
	private ProductExtend product;
	private Product productOrigin;
	

	private int limitSize = 8;
	
	private long productId;//商品的id
	
	@Autowired
	private ClothesService clothesService;
	//衣服
	private Clothes clothes;
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
	 * 获得商品集合找到分类
	 * 在获得分类
	 * @return
	 */
	public String listProducts(){
		this.products = this.productService.getProductByName(keyword, 0);
		List<Long> ids = new ArrayList<Long>();
		for (Product product: this.products){
			ids.add(product.getCategory().getId());
		}
		//分页准备
		this.allCount = this.products.size();
		this.current = this.current == 0? 1: this.current;
		this.allPages = this.allCount % this.limitSize == 0? 
							this.allCount / this.limitSize: this.allCount / this.limitSize + 1;
		this.prev = this.current - 1;
		this.next = this.current + 1;
		if (this.allCount >= limitSize)
			this.products = this.products.subList(0, limitSize);
		else
			this.products = this.products.subList(0, this.allCount);
		
		this.categories = this.categoryService.getCategoriesByIds(ids);
		this.session.put("categories", categories);
		return SUCCESS;
	}
	
	/**
	 * 组合查询的搜索
	 * @return
	 */
	public String condSearchProduct(){
		System.out.println(this.product.getName());
		this.current = this.current == 0? 1: this.current;
		this.prev = this.current - 1;
		this.next = this.current + 1;
		this.allCount = (int) this.productService.getProductSizeByCondition(product);
		this.allPages = this.allCount % this.limitSize == 0? 
				this.allCount / this.limitSize: this.allCount / this.limitSize + 1;
		
		this.products = this.productService.getProductByCondition(product
				, current, limitSize, null);
		
		return SUCCESS;
	}
	
	/**
	 * 获取商品的详细信息
	 * 包括评论。。。
	 * 查询商品的具体信息
	 * 修改商品的访问量
	 * @return
	 * @throws Exception 
	 */
	public String getProductDetail() throws Exception{
		this.productOrigin = this.productService.getProductById(this.productId);
		this.productOrigin.setClick(this.productOrigin.getClick() + 1);
		this.productService.updateProduct(productOrigin);
		switch (this.productOrigin.getCategory().getFromtable()){
		case "clothes":
			System.out.println("商品ID:" + this.productId);
			this.clothes = this.clothesService.findClothesById(this.productId);
			break;
		default:
			//throw new Exception("未找到符合该表名的服务类");
		}
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
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public Product getProductOrigin() {
		return productOrigin;
	}
	public void setProductOrigin(Product productOrigin) {
		this.productOrigin = productOrigin;
	}
	public Clothes getClothes() {
		return clothes;
	}
	public void setClothes(Clothes clothes) {
		this.clothes = clothes;
	}
	
}
