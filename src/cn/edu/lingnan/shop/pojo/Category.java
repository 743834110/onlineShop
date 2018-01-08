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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CATEGORY", schema = "ONLINESHOP")

public class Category implements java.io.Serializable {

	// Fields

	private Long id;
	private String categoryof;
	private String fromtable;
	private Set<Product> products = new HashSet<Product>(0);
	private Set<Clothes> clotheses = new HashSet<Clothes>(0);

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(String categoryof, String fromtable, Set<Product> products, Set<Clothes> clotheses) {
		this.categoryof = categoryof;
		this.fromtable = fromtable;
		this.products = products;
		this.clotheses = clotheses;
	}

	// Property accessors
	@SequenceGenerator(name = "generator_category",allocationSize=1,sequenceName="seq_caty")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator_category")

	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "CATEGORYOF", length = 10)

	public String getCategoryof() {
		return this.categoryof;
	}

	public void setCategoryof(String categoryof) {
		this.categoryof = categoryof;
	}

	@Column(name = "FROMTABLE", length = 20)

	public String getFromtable() {
		return this.fromtable;
	}

	public void setFromtable(String fromtable) {
		this.fromtable = fromtable;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")

	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")

	public Set<Clothes> getClotheses() {
		return this.clotheses;
	}

	public void setClotheses(Set<Clothes> clotheses) {
		this.clotheses = clotheses;
	}

}