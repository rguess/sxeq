package com.dview.sxeq.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SXEQ_ROLE")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
	@SequenceGenerator(name = "role_seq", sequenceName = "role_seq", allocationSize = 1)
	@Column(name = "ID")
	private Long id;

	@Column(name = "ROLENAME")
	private String roleName;

	@Column(name = "GENTIME")
	private Date genTime;

	@Column(name = "DESCRIPTION")
	private String description;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinTable(name = "SXEQ_ROLE_RIGHT", joinColumns = { @JoinColumn(name = "ROLEID") }, inverseJoinColumns = { @JoinColumn(name = "RIGHTID") })
	private List<Right> rights;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Date getGenTime() {
		return genTime;
	}

	public void setGenTime(Date genTime) {
		this.genTime = genTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setRights(List<Right> rights) {
		this.rights = rights;
	}

	public List<Right> getRights() {
		return rights;
	}

}
