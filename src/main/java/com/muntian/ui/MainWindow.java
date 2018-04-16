package com.muntian.ui;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Shell;
import com.muntian.action.AboutMenuAction;
import com.muntian.action.ExitMenuAction;
import com.muntian.action.FindMenuAction;
import com.muntian.action.SaveMenuAction;

public class MainWindow extends ApplicationWindow {

	private static final String TITLE_OF_APP = "JFace homework log";
	
	public MainWindow(Shell parent) {
		super(parent);
	}
	
	public void createComponents() {
//		LogPanel logPanel = new LogPanel(this.getShell(),SWT.NONE);
//		FillLayout fillLayout = new FillLayout();
//		logPanel.setLayout(fillLayout);
		
		setBlockOnOpen(true);
		addMenuBar();
		open();
	}
	
	@Override
	protected MenuManager createMenuManager() {
		MenuManager menuManager = new MenuManager();
		menuManager.add(createFileMenu());
		menuManager.add(createEditMenu());
		menuManager.add(createHelpMenu());
		return menuManager;
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setSize(800, 350);
	      shell.setText(TITLE_OF_APP);
	}
	
	private MenuManager createFileMenu() {
		MenuManager menu = new MenuManager("&File", "Id01");
		menu.add(new SaveMenuAction());
		menu.add(new ExitMenuAction());
		return menu;
	}

	private MenuManager createEditMenu() {
		MenuManager menu = new MenuManager("&Edit", "Id02");
		menu.add(new FindMenuAction());
		return menu;
	}
	
	private MenuManager createHelpMenu() {
		MenuManager menu = new MenuManager("&Help", "Id03");
		menu.add(new AboutMenuAction());
		return menu;
	}
}
