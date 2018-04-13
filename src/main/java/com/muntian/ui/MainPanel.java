package com.muntian.ui;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class MainPanel extends ApplicationWindow {

	private MainMenu mainMenu;
	
	
	public MainPanel(Composite parent) {
		super(parent.getShell());
	}
	
	public void run() {
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}
	
	protected Control createContents(Composite parent) {
		init();
	}
	
	private void init() {
		mainMenu = new MainMenu(this.getShell());
		
	}

}
