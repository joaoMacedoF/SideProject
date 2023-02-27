package com.project.rest.filter;

public enum TransformerEnum {
	

	DATE("DATE"), DATE_HOUR("DATE_HOUR"), CURRENCY("CURRENCY"), NULL_TO_EMPTY("NULL_TO_EMPTY"),BOOLEAN("BOOLEAN"),PARCELA("PARCELA"),
	TEXT("TEXT");

	private String value;

	private TransformerEnum(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	private void setValue(String value) {
		this.value = value;
	}

	public static TransformerEnum getTransformer(String value) {
		for (TransformerEnum t : TransformerEnum.values()) {
			if (t.name().equalsIgnoreCase(value)) {
				return t;
			}
		}
		return null;
	}

}
