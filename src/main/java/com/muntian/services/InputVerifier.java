package com.muntian.services;

public class InputVerifier {
	
	public static boolean verifyInputName(String name) {
		return name.matches("[A-йн-п][р-џ]*");

	}
	
	public static boolean verifyInputGroupNumber(String group) {
		return group.matches("[0-9]*");
	}
}
