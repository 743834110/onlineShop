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
 * Clothes entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CLOTHES", schema = "SCOTT")
public class Clothes implements java.io.Serializable {

	// Fields

	private Long id;
	private User user;
	private String clothessize;
	private String brand;
	private String style;
	private String madeof;
	private String type;

	// Constructors

	/** default constructor */
	public Clothes() {
	}

	/** full constructor */
	public Clothes(User user, String clothessize, String brand, String style,
			String madeof, String type) {
		this.user = user;
		this.clothessize = clothessize;
		this.brand = brand;
		this.style = style;
		this.madeof = madeof;
		this.type = type;
	}

	// Property accessors
	@SequenceGenerator(name = "generator")
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
	@JoinColumn(name = "USERID")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "CLOTHESSIZE", length = 20)
	public String getClothessize() {
		return this.clothessize;
	}

	public void setClothessize(String clothessize) {
		this.clothessize = clothessize;
	}

	@Column(name = "BRAND", length = 20)
	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Column(name = "STYLE", length = 20)
	public String getStyle() {
		return this.style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	@Column(name = "MADEOF", length = 20)
	public String getMadeof() {
		return this.madeof;
	}

	public void setMadeof(String madeof) {
		this.madeof = madeof;
	}

	@Column(name = "TYPE", length = 20)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}