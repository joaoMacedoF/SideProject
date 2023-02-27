package com.project.shared.service.impl;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.shared.converters.RoleConverter;
import com.project.shared.domain.tables.Role;
import com.project.shared.dto.data.RolesDto;
import com.project.shared.dto.request.CreateOrUpdateRoleRequestDto;
import com.project.shared.dto.request.GetRolesRequestDto;
import com.project.shared.dto.response.BaseResponseDto;
import com.project.shared.enums.ErrorCodeEnum;
import com.project.shared.repository.RoleRepository;
import com.project.shared.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	MessageSource messageSource;

	@Autowired
	RoleRepository roleRepository;

	@Override
	public BaseResponseDto<Page<RolesDto>> getRoles(GetRolesRequestDto request, Pageable pageable) {
		BaseResponseDto<Page<RolesDto>> response = new BaseResponseDto<>();
		try {
			Page<Role> roleDb = roleRepository.getRoles(request, pageable);
			response.setResponse(new PageImpl<RolesDto>(roleDb.getContent().stream()
					.map(role -> RoleConverter.convertRoleToRoleDto(role)).collect(Collectors.toList()), pageable, roleDb.getTotalElements()));
			response.setError(ErrorCodeEnum.OK.getErrorCode());
			//response.setMessage(messageSource.getMessage("message.ok", null, null));
		}catch (Exception e) {
			response.setError(ErrorCodeEnum.EXCEPTION_ERROR.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@Transactional
	public BaseResponseDto<RolesDto> createRoles(CreateOrUpdateRoleRequestDto request) {
		BaseResponseDto<RolesDto> response = new BaseResponseDto<>();
		try {
			Role role = new Role();
			role.setRoleName(request.getRoleName());
			role.setRoleDescription(request.getRoleDescrition());

			roleRepository.save(role);

			response.setResponse(RoleConverter.convertRoleToRoleDto(role));
			response.setError(ErrorCodeEnum.OK.getErrorCode());
			//response.setMessage(messageSource.getMessage("message.ok", null, null));
		}catch(Exception e) {
			response.setError(ErrorCodeEnum.EXCEPTION_ERROR.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;

	}
	@Transactional
	public BaseResponseDto<RolesDto> updateRoles(CreateOrUpdateRoleRequestDto request){
		BaseResponseDto<RolesDto> response = new BaseResponseDto<>();
		try {
			Role role = roleRepository.findById(request.getPk()).get();
			role.setRoleName(request.getRoleName());
			role.setRoleDescription(request.getRoleDescrition());

			roleRepository.save(role);

			response.setResponse(RoleConverter.convertRoleToRoleDto(role));
			response.setError(ErrorCodeEnum.OK.getErrorCode());
			//response.setMessage(messageSource.getMessage("message.ok", null, null));
		}catch(Exception e) {
			response.setError(ErrorCodeEnum.EXCEPTION_ERROR.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;

	}

	@Override
	@Transactional
	public BaseResponseDto<RolesDto> createOrUpdateRoles(CreateOrUpdateRoleRequestDto request) {
		if(request.getPk() != null) {
			if(roleRepository.existsById(request.getPk())) {
				return updateRoles(request);
			}else {
				return createRoles(request);
			}
		}else {
			return createRoles(request);
		}
	}

}
