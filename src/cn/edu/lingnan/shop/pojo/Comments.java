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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Comments entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "COMMENTS", schema = "SCOTT")
public class Comments implements java.io.Serializable {

	// Fields

	private Long id;
	private Product product;
	private Comments comments;
	private String content;
	private Date commentdate;
	private Long userid;
	private Set<Comments> commentses = new HashSet<Comments>(0);

	// Constructors

	/** default constructor */
	public Comments() {
	}

	/** full constructor */
	public Comments(Product product, Comments comments, String content,
			Date commentdate, Long userid, Set<Comments> commentses) {
		this.product = product;
		this.comments = comments;
		this.content = content;
		this.commentdate = commentdate;
		this.userid = userid;
		this.commentses = commentses;
	}

	// Property accessors
	@SequenceGenerator(name = "generator", allocationSize = 1, sequenceName = "seq_comm")
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
	@JoinColumn(name = "COMMENTSID")
	public Comments getComments() {
		return this.comments;
	}

	public void setComments(Comments comments) {
		this.comments = comments;
	}

	@Column(name = "CONTENT", length = 100)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "COMMENTDATE", length = 7)
	public Date getCommentdate() {
		return this.commentdate;
	}

	public void setCommentdate(Date commentdate) {
		this.commentdate = commentdate;
	}

	@Column(name = "USERID", precision = 10, scale = 0)
	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comments")
	public Set<Comments> getCommentses() {
		return this.commentses;
	}

	public void setCommentses(Set<Comments> commentses) {
		this.commentses = commentses;
	}

}