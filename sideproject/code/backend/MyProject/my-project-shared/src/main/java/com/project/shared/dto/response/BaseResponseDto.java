package com.project.shared.dto.response;

import java.util.Map;

import com.project.shared.enums.ErrorCodeEnum;

public class BaseResponseDto<T> {
	
	private String error;
	private String message;
	private T response;
	private Map<String, String> optionals;
	
	public BaseResponseDto(String error, String message, T response) {
		super();
		this.error = error;
		this.message = message;
		this.response = response;
	}
	
	public BaseResponseDto() {
		super();
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, String> getOptionals() {
		return optionals;
	}

	public void setOptionals(Map<String, String> optionals) {
		this.optionals = optionals;
	}
	
	public boolean hasError()
	{
		return !ErrorCodeEnum.OK.getErrorCode().equals(this.getError());
	}
	


}
