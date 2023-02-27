package com.project.shared.converters;

import com.project.shared.domain.tables.Role;
import com.project.shared.dto.data.RolesDto;

public class RoleConverter {
	
	public static RolesDto convertRoleToRoleDto(Role role) {
		return new RolesDto(role.getPk(), role.getRoleName(), role.getRoleDescription());
	}

}
