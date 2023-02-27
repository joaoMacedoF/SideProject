package com.project.rest.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.api.RoleApiDelegate;
import com.project.model.CreateOrUpdateRoleApiRequestDto;
import com.project.model.PageRoleDto;
import com.project.model.RequestDtoPageRoleDto;
import com.project.model.ResponseDtoPageRoleDto;
import com.project.model.ResponseDtoRoleDto;
import com.project.rest.converters.RolesConverter;
import com.project.rest.utils.PageUtils;
import com.project.rest.utils.ResponseUtils;
import com.project.shared.dto.data.RolesDto;
import com.project.shared.dto.request.CreateOrUpdateRoleRequestDto;
import com.project.shared.dto.request.GetRolesRequestDto;
import com.project.shared.dto.response.BaseResponseDto;
import com.project.shared.service.RoleService;

@Service
public class RoleApiDelegateImpl implements RoleApiDelegate {
	
	@Autowired
	RoleService roleService;

	@Override
	public ResponseEntity<ResponseDtoRoleDto> createOrUpdateRoleUsingPUT(CreateOrUpdateRoleApiRequestDto apiRequest) {
		HttpStatus responseStatus = HttpStatus.OK;
		ResponseDtoRoleDto apiResponseDto = new ResponseDtoRoleDto();
		try {
			CreateOrUpdateRoleRequestDto requestDto = new CreateOrUpdateRoleRequestDto();
			requestDto.setPk(apiRequest.getPk());
			requestDto.setRoleName(apiRequest.getRoleName());
			requestDto.setRoleDescrition(apiRequest.getRoleDescription());
			
			BaseResponseDto<RolesDto> businessResponseDto = roleService.createOrUpdateRoles(requestDto);
			responseStatus = ResponseUtils.fillErrorData(apiResponseDto, businessResponseDto);
			apiResponseDto.setResponse(RolesConverter.convertSharedRoleDtoToModelDto(businessResponseDto.getResponse()));
		}catch(Exception e) {
			responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(apiResponseDto, responseStatus);
	}

	@Override
	public ResponseEntity<ResponseDtoPageRoleDto> getRolesUsingGET(RequestDtoPageRoleDto apiRequest, Pageable pageable,
			Boolean unpaged) {
		HttpStatus responseStatus = HttpStatus.OK;
		ResponseDtoPageRoleDto apiResponseDto = new ResponseDtoPageRoleDto();
		try {
			
			if (unpaged != null && unpaged)
				pageable = PageRequest.of(0, Integer.MAX_VALUE, pageable.getSort());
			
			GetRolesRequestDto requestDto = new GetRolesRequestDto();
			requestDto.setRoleName(apiRequest.getRoleName());
			requestDto.setRoleDescription(apiRequest.getRoleDescription());
			
			BaseResponseDto<Page<RolesDto>> businessResponseDto = roleService.getRoles(requestDto, pageable);
			responseStatus = ResponseUtils.fillErrorData(apiResponseDto, businessResponseDto);
			
			if(!businessResponseDto.hasError()) {
				PageRoleDto apiPageDto = new PageRoleDto();
				apiPageDto.setMetadata(PageUtils.createMetadataFromPage(businessResponseDto.getResponse()));
				apiPageDto.setData(businessResponseDto.getResponse().stream()
						.map(dto -> RolesConverter.convertSharedRoleDtoToModelDto(dto)).collect(Collectors.toList()));
				apiResponseDto.setResponse(apiPageDto);
			}
			
		}catch(Exception e) {
			responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(apiResponseDto, responseStatus);
	}
	
	

}
