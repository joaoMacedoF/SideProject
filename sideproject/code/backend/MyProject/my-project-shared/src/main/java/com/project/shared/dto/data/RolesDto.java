package com.project.shared.dto.data;

public class RolesDto {
	
	private Long pk;
	private String roleName;
	private String roleDescription;
	
	
	public RolesDto() {
		super();
	}


	public RolesDto(Long pk, String roleName, String roleDescription) {
		super();
		this.pk = pk;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}


	public Long getPk() {
		return pk;
	}


	public void setPk(Long pk) {
		this.pk = pk;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getRoleDescription() {
		return roleDescription;
	}


	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	
	

}
