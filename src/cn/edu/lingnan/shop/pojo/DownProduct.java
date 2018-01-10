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

/**
 * DownProduct entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "DWNPRODUCT", schema = "SCOTT")
public class DownProduct implements java.io.Serializable {

	// Fields

	private Long id;
	private Product product;
	private Date downdate;
	private String reason;
	private Long userid;
	private Date onshelfdate;

	// Constructors

	/** default constructor */
	public DownProduct() {
	}

	/** full constructor */
	public DownProduct(Product product, Date downdate, String reason,
			Long userid, Date onshelfdate) {
		this.product = product;
		this.downdate = downdate;
		this.reason = reason;
		this.userid = userid;
		this.onshelfdate = onshelfdate;
	}

	// Property accessors
	@SequenceGenerator(name = "generator", allocationSize = 1, sequenceName = "seq_dwpt")
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

	@Temporal(TemporalType.DATE)
	@Column(name = "DOWNDATE", length = 7)
	public Date getDowndate() {
		return this.downdate;
	}

	public void setDowndate(Date downdate) {
		this.downdate = downdate;
	}

	@Column(name = "REASON", length = 256)
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Column(name = "USERID", precision = 10, scale = 0)
	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ONSHELFDATE", length = 7)
	public Date getOnshelfdate() {
		return this.onshelfdate;
	}

	public void setOnshelfdate(Date onshelfdate) {
		this.onshelfdate = onshelfdate;
	}

}