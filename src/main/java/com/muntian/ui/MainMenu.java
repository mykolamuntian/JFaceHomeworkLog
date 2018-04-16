package com.muntian.ui;

import org.eclipse.jface.action.MenuManager;

import com.muntian.action.AboutMenuAction;
import com.muntian.action.ExitMenuAction;
import com.muntian.action.SaveMenuAction;

public class MainMenu {
	
	public MainMenu() {
		
	}
	
	protected MenuManager createMenuManager() {
		MenuManager menuManager = new MenuManager();
		menuManager.add(createFileMenu());
		menuManager.add(createEditMenu());
		menuManager.add(createHelpMenu());

		return menuManager;
	}

	protected MenuManager createFileMenu() {
		MenuManager menu = new MenuManager("&File", "Id01");
		menu.add(new SaveMenuAction());
		menu.add(new ExitMenuAction());
		return menu;
	}

	protected MenuManager createEditMenu() {
		MenuManager menu = new MenuManager("&Edit", "Id02");
		return menu;
	}
	
	protected MenuManager createHelpMenu() {
		MenuManager menu = new MenuManager("&Help", "Id03");
		menu.add(new AboutMenuAction());
		return menu;
	}

}
