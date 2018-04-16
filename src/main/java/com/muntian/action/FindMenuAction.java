package com.muntian.action;

import org.eclipse.jface.action.Action;

public class FindMenuAction extends Action {

	public String getText() {
		return "&Find";
	}
	
	public void run() {
		System.out.println("Find menu action");
	}
}
