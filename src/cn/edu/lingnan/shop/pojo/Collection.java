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
 * Collection entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "COLLECTION", schema = "ONLINESHOP")

public class Collection implements java.io.Serializable {

	// Fields

	private Long id;
	private User user;
	private Product product;

	// Constructors

	/** default constructor */
	public Collection() {
	}

	/** full constructor */
	public Collection(User user, Product product) {
		this.user = user;
		this.product = product;
	}

	// Property accessors
	@SequenceGenerator(name = "generator_collection",allocationSize=1,sequenceName="seq_coll")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator_collection")

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCTID")

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}