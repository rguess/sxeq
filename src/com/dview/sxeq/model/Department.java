package com.dview.sxeq.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SXEQ_DEPART")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "depart_seq")
	@SequenceGenerator(name = "depart_seq", sequenceName = "depart_seq", allocationSize = 1)
	@Column(name="ID")
	private Long id;
	
	@Column(name = "DEPARTMENTNAME")
	private String departmentName;
	
	@Column(name = "DESCRIPTION")
	private String desciption;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	
	
}
