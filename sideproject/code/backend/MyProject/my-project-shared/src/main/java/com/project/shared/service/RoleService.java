package com.project.shared.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.shared.dto.data.RolesDto;
import com.project.shared.dto.request.CreateOrUpdateRoleRequestDto;
import com.project.shared.dto.request.GetRolesRequestDto;
import com.project.shared.dto.response.BaseResponseDto;

public interface RoleService {
	
	BaseResponseDto<Page<RolesDto>> getRoles(GetRolesRequestDto request, Pageable pageable);
	
	BaseResponseDto<RolesDto> createOrUpdateRoles(CreateOrUpdateRoleRequestDto request);

}
