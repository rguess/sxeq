package com.dview.sxeq.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SXEQ_RIGHT")
public class Right {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "right_seq")
	@SequenceGenerator(name = "right_seq", sequenceName = "right_seq", allocationSize = 1)
	@Column(name="ID")
	private Long id;
	
	@Column(name = "RIGHTSTR")
	private String rightStr;
	
	@Column(name = "RIGHTNAME")
	private String rightName;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRightStr() {
		return rightStr;
	}
	public void setRightStr(String rightStr) {
		this.rightStr = rightStr;
	}
	public String getRightName() {
		return rightName;
	}
	public void setRightName(String rightName) {
		this.rightName = rightName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
