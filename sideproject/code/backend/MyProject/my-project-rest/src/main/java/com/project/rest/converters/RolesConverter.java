package com.project.rest.converters;

import com.project.model.RoleDto;
import com.project.shared.dto.data.RolesDto;

public class RolesConverter {
	
	public static RoleDto convertSharedRoleDtoToModelDto(RolesDto sharedDto) {
		
		RoleDto modelDto = new RoleDto();
		modelDto.setPk(sharedDto.getPk());
		modelDto.setRoleName(sharedDto.getRoleName());
		modelDto.setRoleDescription(sharedDto.getRoleDescription());
		
		return modelDto;
	}

}
