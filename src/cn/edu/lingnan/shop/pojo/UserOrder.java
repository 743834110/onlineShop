package cn.edu.lingnan.shop.pojo;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * UserOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "USER_ORDER", schema = "SCOTT", uniqueConstraints = @UniqueConstraint(columnNames = "ORDERNUM"))
public class UserOrder implements java.io.Serializable {

	// Fields

	private Long id;
	private Address address;
	private Product product;
	private User user;
	private String ordernum;
	private Double price;
	private Long num;
	private Boolean status;
	private Date startdate;
	private Boolean valid;

	// Constructors

	/** default constructor */
	public UserOrder() {
	}

	/** minimal constructor */
	public UserOrder(String ordernum) {
		this.ordernum = ordernum;
	}

	/** full constructor */
	public UserOrder(Address address, Product product, User user,
			String ordernum, Double price, Long num, Boolean status,
			Date startdate, Boolean valid) {
		this.address = address;
		this.product = product;
		this.user = user;
		this.ordernum = ordernum;
		this.price = price;
		this.num = num;
		this.status = status;
		this.startdate = startdate;
		this.valid = valid;
	}

	// Property accessors
	@SequenceGenerator(name = "generator")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, precision = 15, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ADDRESSID")
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
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

	@Column(name = "ORDERNUM", unique = true, nullable = false, length = 15)
	public String getOrdernum() {
		return this.ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
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

	@Column(name = "STATUS", precision = 1, scale = 0)
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "STARTDATE", length = 7)
	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	@Column(name = "VALID", precision = 1, scale = 0)
	public Boolean getValid() {
		return this.valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

}