package cn.edu.lingnan.shop.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DownProduct entity. @author MyEclipse Persistence Tools
 * 下架的商品表
 */
@Entity
@Table(name = "DWNPRODUCT", schema = "SCOTT")
public class DownProduct implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private Double price;
	private Double oginprice;
	private Long transfee;
	private Long accumulate;
	private Long surplus;
	private String detail;
	private Date productdate;
	private String madein;
	private Date downdate;
	private String reason;
	private Long productid;
	private Long userid;
	private Date onshelfdate;
	private String fromtable;
	private Long categoryid;

	// Constructors

	/** default constructor */
	public DownProduct() {
	}

	/** minimal constructor */
	public DownProduct(String name) {
		this.name = name;
	}

	/** full constructor */
	public DownProduct(String name, Double price, Double oginprice,
			Long transfee, Long accumulate, Long surplus, String detail,
			Date productdate, String madein, Date downdate, String reason,
			Long productid, Long userid, Date onshelfdate, String fromtable,
			Long categoryid) {
		this.name = name;
		this.price = price;
		this.oginprice = oginprice;
		this.transfee = transfee;
		this.accumulate = accumulate;
		this.surplus = surplus;
		this.detail = detail;
		this.productdate = productdate;
		this.madein = madein;
		this.downdate = downdate;
		this.reason = reason;
		this.productid = productid;
		this.userid = userid;
		this.onshelfdate = onshelfdate;
		this.fromtable = fromtable;
		this.categoryid = categoryid;
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

	@Column(name = "TRANSFEE", precision = 10, scale = 0)
	public Long getTransfee() {
		return this.transfee;
	}

	public void setTransfee(Long transfee) {
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

	@Column(name = "PRODUCTID", precision = 10, scale = 0)
	public Long getProductid() {
		return this.productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
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

	@Column(name = "FROMTABLE", length = 20)
	public String getFromtable() {
		return this.fromtable;
	}

	public void setFromtable(String fromtable) {
		this.fromtable = fromtable;
	}

	@Column(name = "CATEGORYID", precision = 10, scale = 0)
	public Long getCategoryid() {
		return this.categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

}