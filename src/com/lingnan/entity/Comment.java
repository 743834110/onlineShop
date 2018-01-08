package com.lingnan.entity;

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
 * Comment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "NEW_COMMENT", schema = "SCOTT")
public class Comment implements java.io.Serializable {

	// Fields

	private Integer id;
	private NewsDetail newsDetail;
	private String content;
	private String author;
	private Date createdate;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** minimal constructor */
	public Comment(String content, Date createdate) {
		this.content = content;
		this.createdate = createdate;
	}

	/** full constructor */
	public Comment(NewsDetail newsDetail, String content, String author,
			Date createdate) {
		this.newsDetail = newsDetail;
		this.content = content;
		this.author = author;
		this.createdate = createdate;
	}

	// Property accessors
	@SequenceGenerator(name = "generator", allocationSize = 1, sequenceName = "seq_comment")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NEWSID")
	public NewsDetail getNewsDetail() {
		return this.newsDetail;
	}

	public void setNewsDetail(NewsDetail newsDetail) {
		this.newsDetail = newsDetail;
	}

	@Column(name = "CONTENT", nullable = false)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "AUTHOR", length = 50)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATEDATE", nullable = false, length = 7)
	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

}