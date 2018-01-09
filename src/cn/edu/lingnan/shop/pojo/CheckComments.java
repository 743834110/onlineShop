package cn.edu.lingnan.shop.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * CheckComments entity. @author MyEclipse Persistence Tools
 * 评论审核表
 */
@Entity
@Table(name = "CKCOMMENTS", schema = "SCOTT")
public class CheckComments implements java.io.Serializable {

	// Fields

	private Long id;
	private Long commentsid;
	private Long ischeck;

	// Constructors

	/** default constructor */
	public CheckComments() {
	}

	/** full constructor */
	public CheckComments(Long commentsid, Long ischeck) {
		this.commentsid = commentsid;
		this.ischeck = ischeck;
	}

	// Property accessors
	@SequenceGenerator(name = "generator", allocationSize = 1, sequenceName = "seq_chks")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "COMMENTSID", precision = 10, scale = 0)
	public Long getCommentsid() {
		return this.commentsid;
	}

	public void setCommentsid(Long commentsid) {
		this.commentsid = commentsid;
	}

	@Column(name = "ISCHECK", precision = 10, scale = 0)
	public Long getIscheck() {
		return this.ischeck;
	}

	public void setIscheck(Long ischeck) {
		this.ischeck = ischeck;
	}

}