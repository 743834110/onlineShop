package cn.edu.lingnan.shop.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Cart entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CART", schema = "SCOTT")
public class Cart implements java.io.Serializable {

	// Fields

	private Long id;
	private Product product;
	private User user;
	private Double price;
	private Long num;

	// Constructors

	/** default constructor */
	public Cart() {
	}

	/** full constructor */
	public Cart(Product product, User user, Double price, Long num) {
		this.product = product;
		this.user = user;
		this.price = price;
		this.num = num;
	}

	// Property accessors
	@SequenceGenerator(name = "generator", allocationSize = 1, sequenceName = "seq_cart")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCTID")
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERID")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "PRICE", precision = 9)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "NUM", precision = 10, scale = 0)
	public Long getNum() {
		return this.num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

}