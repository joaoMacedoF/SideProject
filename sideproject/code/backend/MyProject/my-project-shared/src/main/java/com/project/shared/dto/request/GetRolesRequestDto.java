package com.project.shared.dto.request;

public class GetRolesRequestDto {
	
	private String roleName;
	private String roleDescription;
	
	
	public GetRolesRequestDto() {
		super();
	}


	public GetRolesRequestDto(String roleName, String roleDescription) {
		super();
		this.roleName = roleName;
		this.roleDescription = roleDescription;
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
