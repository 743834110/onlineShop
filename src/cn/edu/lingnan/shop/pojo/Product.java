package cn.edu.lingnan.shop.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PRODUCT", schema = "SCOTT")
public class Product implements java.io.Serializable {

	// Fields

	private Long id;
	private Category category;
	private User user;
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
	private List<DownProduct> downProducts = new ArrayList<DownProduct>(0);
	private List<ProductImages> productImages = new ArrayList<ProductImages>(0);
	private List<Cart> carts = new ArrayList<Cart>(0);
	private List<UserOrder> userOrders = new ArrayList<UserOrder>(0);
	private List<Collection> collections = new ArrayList<Collection>(0);
	private List<Comments> commentses = new ArrayList<Comments>(0);


	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(String name) {
		this.name = name;
	}

	/** full constructor */
	public Product(Category category, User user, String name, Double price,
			Double oginprice, Integer transfee, Long accumulate, Long surplus,
			String detail, Date productdate, String madein, String fromtable,
			Long offshelf, List<DownProduct> downProducts,
			List<ProductImages> productImages, List<Cart> carts,
			List<UserOrder> userOrders, List<Collection> collections,
			List<Comments> commentses) {

		this.category = category;
		this.user = user;
		this.name = name;
		this.price = price;
		this.oginprice = oginprice;
		this.transfee = transfee;
		this.accumulate = accumulate;
		this.surplus = surplus;
		this.detail = detail;
		this.productdate = productdate;
		this.madein = madein;
		this.fromtable = fromtable;
		this.offshelf = offshelf;
		this.downProducts = downProducts;
		this.productImages = productImages;
		this.carts = carts;
		this.userOrders = userOrders;
		this.collections = collections;
		this.commentses = commentses;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy="cn.edu.lingnan.shop.utils.OrderKeyGen")
	@Id
	@GeneratedValue (generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORYID")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERID")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "NAME", nullable = false, length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PRICE", precision = 9)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "OGINPRICE", precision = 9)
	public Double getOginprice() {
		return this.oginprice;
	}

	public void setOginprice(Double oginprice) {
		this.oginprice = oginprice;
	}

	@Column(name = "TRANSFEE", precision = 2, scale = 0)
	public Integer getTransfee() {
		return this.transfee;
	}

	public void setTransfee(Integer transfee) {
		this.transfee = transfee;
	}

	@Column(name = "ACCUMULATE", precision = 10, scale = 0)
	public Long getAccumulate() {
		return this.accumulate;
	}

	public void setAccumulate(Long accumulate) {
		this.accumulate = accumulate;
	}

	@Column(name = "SURPLUS", precision = 10, scale = 0)
	public Long getSurplus() {
		return this.surplus;
	}

	public void setSurplus(Long surplus) {
		this.surplus = surplus;
	}

	@Column(name = "DETAIL", length = 200)
	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PRODUCTDATE", length = 7)
	public Date getProductdate() {
		return this.productdate;
	}

	public void setProductdate(Date productdate) {
		this.productdate = productdate;
	}

	@Column(name = "MADEIN", length = 50)
	public String getMadein() {
		return this.madein;
	}

	public void setMadein(String madein) {
		this.madein = madein;
	}

	@Column(name = "FROMTABLE", length = 20)
	public String getFromtable() {
		return this.fromtable;
	}

	public void setFromtable(String fromtable) {
		this.fromtable = fromtable;
	}

	@Column(name = "OFFSHELF", precision = 10, scale = 0)
	public Long getOffshelf() {
		return this.offshelf;
	}

	public void setOffshelf(Long offshelf) {
		this.offshelf = offshelf;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	public List<DownProduct> getDownProducts() {
		return this.downProducts;
	}

	public void setDownProducts(List<DownProduct> downProducts) {
		this.downProducts = downProducts;
	}

	
	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	public List<Cart> getCarts() {
		return this.carts;
	}
	
	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	public List<ProductImages> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<ProductImages> productImages) {
		this.productImages = productImages;
	}

	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	public List<UserOrder> getUserOrders() {
		return this.userOrders;
	}

	public void setUserOrders(List<UserOrder> userOrders) {
		this.userOrders = userOrders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	public List<Collection> getCollections() {
		return this.collections;
	}

	public void setCollections(List<Collection> collections) {
		this.collections = collections;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	public List<Comments> getCommentses() {
		return this.commentses;
	}

	public void setCommentses(List<Comments> commentses) {
		this.commentses = commentses;
	}

}