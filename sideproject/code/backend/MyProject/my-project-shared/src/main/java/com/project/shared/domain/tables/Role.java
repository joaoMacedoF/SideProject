package com.project.shared.domain.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	
	private Long pk;
	private String roleName;
	private String roleDescription;
	
	
	public Role() {
		super();
	}


	public Role(Long pk, String roleName, String roleDescription) {
		super();
		this.pk = pk;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getPk() {
		return pk;
	}


	public void setPk(Long pk) {
		this.pk = pk;
	}

	@Column(name = "role_name")
	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "role_description")
	public String getRoleDescription() {
		return roleDescription;
	}


	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	
	

}
