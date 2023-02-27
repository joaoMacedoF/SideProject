package com.project.shared.enums;

public enum SimNaoEnum {
	
	SIM('S'),
	NAO('N');
	
	private char code;
	
	private SimNaoEnum(char code)
	{
		this.setCode(code);
	}

	public char getCode() {
		return code;
	}
	
	public String getCodeString() {
		return code+"";
	}

	private void setCode(char code) {
		this.code = code;
	}

	public static boolean getBooleanValue(char code) {
		if(code== SIM.getCode()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static char getCharValue(boolean bool) {
		if(bool) {
			return SIM.getCode();
		}else {
			return NAO.getCode();
		}
	}

}
