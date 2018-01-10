package cn.edu.lingnan.shop.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SHOP_USER", schema = "SCOTT", uniqueConstraints = @UniqueConstraint(columnNames = "USERNAME"))
public class User implements java.io.Serializable {

	// Fields

	private Long id;
	private String username;
	private String password;
	private String email;
	private String realname;
	private String idcard;
	private String sex;
	private String pic;
	private Boolean type;
	private Long addressid;
	private Date registerdate;
	private Set<Comments> commentses = new HashSet<Comments>(0);
	private Set<UserOrder> userOrders = new HashSet<UserOrder>(0);
	private Set<Collection> collections = new HashSet<Collection>(0);
	private Set<Cart> carts = new HashSet<Cart>(0);
	private Set<Address> addresses = new HashSet<Address>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username, String password, String realname, String idcard) {
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.idcard = idcard;
	}

	/** full constructor */
	public User(String username, String password, String email,
			String realname, String idcard, String sex, String pic,
			Boolean type, Long addressid, Date registerdate,
			Set<Comments> commentses, Set<UserOrder> userOrders,
			Set<Collection> collections, Set<Cart> carts, Set<Address> addresses) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.realname = realname;
		this.idcard = idcard;
		this.sex = sex;
		this.pic = pic;
		this.type = type;
		this.addressid = addressid;
		this.registerdate = registerdate;
		this.commentses = commentses;
		this.userOrders = userOrders;
		this.collections = collections;
		this.carts = carts;
		this.addresses = addresses;
	}

	// Property accessors
	@SequenceGenerator(name = "generator", allocationSize = 1, sequenceName = "seq_user")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "USERNAME", unique = true, nullable = false, length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", nullable = false, length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "EMAIL", length = 20)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "REALNAME", nullable = false, length = 20)
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "IDCARD", nullable = false, length = 20)
	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	@Column(name = "SEX", length = 2)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "PIC", length = 100)
	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Column(name = "TYPE", precision = 1, scale = 0)
	public Boolean getType() {
		return this.type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	@Column(name = "ADDRESSID", precision = 10, scale = 0)
	public Long getAddressid() {
		return this.addressid;
	}

	public void setAddressid(Long addressid) {
		this.addressid = addressid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "REGISTERDATE", length = 7)
	public Date getRegisterdate() {
		return this.registerdate;
	}

	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Comments> getCommentses() {
		return this.commentses;
	}

	public void setCommentses(Set<Comments> commentses) {
		this.commentses = commentses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserOrder> getUserOrders() {
		return this.userOrders;
	}

	public void setUserOrders(Set<UserOrder> userOrders) {
		this.userOrders = userOrders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Collection> getCollections() {
		return this.collections;
	}

	public void setCollections(Set<Collection> collections) {
		this.collections = collections;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

}