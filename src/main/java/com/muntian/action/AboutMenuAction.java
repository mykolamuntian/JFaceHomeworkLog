package com.muntian.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;

import com.muntian.ui.MainWindow;

public class AboutMenuAction extends Action {

	public String getText() {
		return "&About";
	}

	public void run() {
		String message = "This program allows you to keep a log of homework."
				+ " Provides the ability to add, delete students,"
				+ " sort the log by name, group or completed homework."
				+ " And also it is possible to save the edited log to a file.";
		
		MessageDialog dialog = new MessageDialog(MainWindow.getInstance().getShell(), "About the program", null,
			    message, MessageDialog.INFORMATION, new String[] { "Close"}, 0);
			dialog.open();
	}
}
