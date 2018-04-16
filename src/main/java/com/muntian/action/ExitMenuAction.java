package com.muntian.action;

import org.eclipse.jface.action.Action;

public class ExitMenuAction extends Action {
	public String getText() {
		return "&Exit";
	}
	
	public void run() {
		System.out.println("Exit menu action");
	}
}
