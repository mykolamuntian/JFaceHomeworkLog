package com.muntian.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;

import com.muntian.Main;

public class ExitMenuAction extends Action {
	public String getText() {
		return "&Exit";
	}
	
	public void run() {
		String message = "Are you sure you want to exit?";
		if(MessageDialog.openConfirm(Main.getShell(), "Exit", message)){
			Main.getShell().close();
		}
	}
}
