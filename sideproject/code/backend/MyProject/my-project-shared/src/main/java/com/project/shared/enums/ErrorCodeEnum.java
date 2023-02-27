package com.project.shared.enums;

public enum ErrorCodeEnum {
	
	OK("0"),
	MANDATORY("1"),
	EXCEPTION_ERROR("-1");
	
	private String errorCode;
	
	private ErrorCodeEnum(String errorCode)
	{
		this.setErrorCode(errorCode);
	}

	public String getErrorCode() {
		return errorCode;
	}

	private void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
