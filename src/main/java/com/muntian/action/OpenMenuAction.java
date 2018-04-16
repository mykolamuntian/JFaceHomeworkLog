package com.muntian.action;

import org.eclipse.jface.action.Action;

public class OpenMenuAction extends Action{
	public String getText() {
		return "&Open";
	}
	
	public void run() {
		System.out.println("Open menu action");
	}
}
