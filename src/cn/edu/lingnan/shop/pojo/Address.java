package cn.edu.lingnan.shop.pojo;

import java.util.HashSet;
import java.util.Set;
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
import javax.persistence.UniqueConstraint;

/**
 * Address entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ADDRESS", schema = "ONLINESHOP", uniqueConstraints = @UniqueConstraint(columnNames = "USERNAME"))
public class Address implements java.io.Serializable {

	// Fields

	private Long id;
	private User user;
	private String username;
	private String country;
	private String postcode;
	private String telephone;
	private String extra;
	private Set<UserOrder> userOrders = new HashSet<UserOrder>(0);

	// Constructors

	/** default constructor */
	public Address() {
	}

	/** minimal constructor */
	public Address(String username) {
		this.username = username;
	}

	/** full constructor */
	public Address(User user, String username, String country, String postcode, String telephone, String extra,
			Set<UserOrder> userOrders) {
		this.user = user;
		this.username = username;
		this.country = country;
		this.postcode = postcode;
		this.telephone = telephone;
		this.extra = extra;
		this.userOrders = userOrders;
	}

	// Property accessors
	@SequenceGenerator(name = "generator_address",allocationSize=1,sequenceName="seq_addr")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator_address")
	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERID")

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "USERNAME", unique = true, nullable = false, length = 20)

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "COUNTRY", length = 50)

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "POSTCODE", length = 10)

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Column(name = "TELEPHONE", length = 20)

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "EXTRA", length = 50)

	public String getExtra() {
		return this.extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "address")

	public Set<UserOrder> getUserOrders() {
		return this.userOrders;
	}

	public void setUserOrders(Set<UserOrder> userOrders) {
		this.userOrders = userOrders;
	}

}