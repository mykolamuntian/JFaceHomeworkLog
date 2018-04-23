package com.muntian.ui.table;

public enum CheckedState {
	
	CHECKED("checked.png"),
	UNCHECKED("unchecked.png") ;

	String fileName;
	
	CheckedState(String fileName){
		this.fileName = fileName;
	}
	
	public String getValue() {
		return fileName;
	}
}
