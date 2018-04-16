package com.muntian.action;

import org.eclipse.jface.action.Action;

public class SaveMenuAction extends Action{
	public String getText() {
		return "&Save";
	}
	
	public void run() {
		System.out.println("Save menu action");
	}
}
