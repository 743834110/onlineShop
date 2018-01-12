package cn.edu.lingnan.shop.pojo;

import java.util.Date;

public class ProductExtend extends Product{
	
	private Long id;
	private String name;
	private Double price;
	private Double oginprice;
	private Integer transfee;
	private Long accumulate;
	private Long surplus;
	private String detail;
	private Date productdate;
	private String madein;
	private String fromtable;
	private Long offshelf;
	private Double lowPrice;//上行低价格
	private Double highPrice;//下行高价格
	
	private Integer sales;//销量
	private Integer click;//人气
	private Double credit;//信用
	
	
	
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	public Integer getClick() {
		return click;
	}
	public void setClick(Integer click) {
		this.click = click;
	}
	public Double getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(Double lowPrice) {
		this.lowPrice = lowPrice;
	}
	public Double getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(Double highPrice) {
		this.highPrice = highPrice;
	}
	public Double getCredit() {
		return credit;
	}
	public void setCredit(Double credit) {
		this.credit = credit;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("运行子类中的setName");
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getOginprice() {
		return oginprice;
	}
	public void setOginprice(Double oginprice) {
		this.oginprice = oginprice;
	}
	public Integer getTransfee() {
		return transfee;
	}
	public void setTransfee(Integer transfee) {
		this.transfee = transfee;
	}
	public Long getAccumulate() {
		return accumulate;
	}
	public void setAccumulate(Long accumulate) {
		this.accumulate = accumulate;
	}
	public Long getSurplus() {
		return surplus;
	}
	public void setSurplus(Long surplus) {
		this.surplus = surplus;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getProductdate() {
		return productdate;
	}
	public void setProductdate(Date productdate) {
		this.productdate = productdate;
	}
	public String getMadein() {
		return madein;
	}
	public void setMadein(String madein) {
		this.madein = madein;
	}
	public String getFromtable() {
		return fromtable;
	}
	public void setFromtable(String fromtable) {
		this.fromtable = fromtable;
	}
	public Long getOffshelf() {
		return offshelf;
	}
	public void setOffshelf(Long offshelf) {
		this.offshelf = offshelf;
	}
	
	
	
}
