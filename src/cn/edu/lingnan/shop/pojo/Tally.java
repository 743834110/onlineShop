package cn.edu.lingnan.shop.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * Tally entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TALLY", schema = "SCOTT")
public class Tally implements java.io.Serializable {

	// Fields

	private String id;
	private Long currentaccess;
	private Long totalaccess;

	// Constructors

	/** default constructor */
	public Tally() {
	}

	/** full constructor */
	public Tally(Long currentaccess, Long totalaccess) {
		this.currentaccess = currentaccess;
		this.totalaccess = totalaccess;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy="cn.edu.lingnan.shop.utils.TallyKeyGen")
	@Id
	@GeneratedValue (generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, length = 20)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "CURRENTACCESS", precision = 10, scale = 0)
	public Long getCurrentaccess() {
		return this.currentaccess;
	}

	public void setCurrentaccess(Long currentaccess) {
		this.currentaccess = currentaccess;
	}

	@Column(name = "TOTALACCESS", precision = 10, scale = 0)
	public Long getTotalaccess() {
		return this.totalaccess;
	}

	public void setTotalaccess(Long totalaccess) {
		this.totalaccess = totalaccess;
	}

}