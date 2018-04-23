package com.muntian.ui.table;

public enum CheckedState {
	
	CHECKED("src/main/resources/img/checked.png"),
	UNCHECKED("src/main/resources/img/unchecked.png") ;

	String fileName;
	
	CheckedState(String fileName){
		this.fileName = fileName;
	}
	
	public String getValue() {
		return fileName;
	}
}
