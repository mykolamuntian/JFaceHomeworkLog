package com.muntian.action;

import org.eclipse.jface.action.Action;

import com.muntian.logic.ModelTableData;
import com.muntian.services.LogFileAccessManager;

public class SaveMenuAction extends Action{
	public String getText() {
		return "&Save";
	}
	
	public void run() {
		System.out.println("Save menu action");
		new LogFileAccessManager().writeLogItemsToFile("log.json", ModelTableData.getInstance().getItems());
	}
}
