package com.project.rest.utils;

import org.springframework.http.HttpStatus;

import com.project.model.ResponseDto;
import com.project.shared.dto.response.BaseResponseDto;
import com.project.shared.enums.ErrorCodeEnum;

public class ResponseUtils {
	
	public static HttpStatus fillErrorData(ResponseDto modelResponseDto, BaseResponseDto<?> businessResponseDto)
	{
		modelResponseDto.setError(businessResponseDto.getError());
		modelResponseDto.setMessage(businessResponseDto.getMessage());
		modelResponseDto.setOptionals(businessResponseDto.getOptionals());
		
		if(!businessResponseDto.getError().equalsIgnoreCase(ErrorCodeEnum.OK.getErrorCode()))
			return HttpStatus.BAD_REQUEST;
		else
			return HttpStatus.OK;
	}

}
