package com.muntian.action;

import org.eclipse.jface.action.Action;

public class AboutMenuAction extends Action {

	public String getText() {
		return "&About";
	}
	
	public void run() {
		System.out.println("About menu action");
	}
}
