package com.project.shared.dto.request;

public class CreateOrUpdateRoleRequestDto {
	
	private Long pk;
	private String roleName;
	private String roleDescrition;
	
	
	public CreateOrUpdateRoleRequestDto() {
		super();
	}


	public CreateOrUpdateRoleRequestDto(Long pk, String roleName, String roleDescrition) {
		super();
		this.pk = pk;
		this.roleName = roleName;
		this.roleDescrition = roleDescrition;
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


	public String getRoleDescrition() {
		return roleDescrition;
	}


	public void setRoleDescrition(String roleDescrition) {
		this.roleDescrition = roleDescrition;
	}
	
	

}
