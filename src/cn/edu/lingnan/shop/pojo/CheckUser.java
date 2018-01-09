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
 * CheckUser entity. @author MyEclipse Persistence Tools
 * 审核卖家表
 */
@Entity
@Table(name = "CKUSER", schema = "SCOTT")
public class CheckUser implements java.io.Serializable {

	// Fields

	private Long id;
	private Date requestdate;
	private Long authortype;
	private String authorpic;
	private Date agreedate;
	private String msg;
	private Long userid;

	// Constructors

	/** default constructor */
	public CheckUser() {
	}

	/** full constructor */
	public CheckUser(Date requestdate, Long authortype, String authorpic,
			Date agreedate, String msg, Long userid) {
		this.requestdate = requestdate;
		this.authortype = authortype;
		this.authorpic = authorpic;
		this.agreedate = agreedate;
		this.msg = msg;
		this.userid = userid;
	}

	// Property accessors
	@SequenceGenerator(name = "generator", allocationSize = 1, sequenceName = "seq_chur")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "REQUESTDATE", length = 7)
	public Date getRequestdate() {
		return this.requestdate;
	}

	public void setRequestdate(Date requestdate) {
		this.requestdate = requestdate;
	}

	@Column(name = "AUTHORTYPE", precision = 10, scale = 0)
	public Long getAuthortype() {
		return this.authortype;
	}

	public void setAuthortype(Long authortype) {
		this.authortype = authortype;
	}

	@Column(name = "AUTHORPIC", length = 256)
	public String getAuthorpic() {
		return this.authorpic;
	}

	public void setAuthorpic(String authorpic) {
		this.authorpic = authorpic;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AGREEDATE", length = 7)
	public Date getAgreedate() {
		return this.agreedate;
	}

	public void setAgreedate(Date agreedate) {
		this.agreedate = agreedate;
	}

	@Column(name = "MSG", length = 256)
	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Column(name = "USERID", precision = 10, scale = 0)
	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

}