package com.dview.sxeq.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SXEQ_LOG")
public class Log {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_seq")
	@SequenceGenerator(name = "log_seq", sequenceName = "log_seq", allocationSize = 1)
	@Column(name="ID")
	private Long id;
	
	@Column(name = "REMARK")
	private String remark;
	
	@Column(name = "CONTENT")
	private String content;
	
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "OPRID", nullable = true)
	private User user;
	
	@Column(name = "GENTIME")
	private Date date;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
