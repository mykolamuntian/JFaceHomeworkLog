package com.muntian.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class MainMenu {
	private Menu menuBar;
	private Menu fileMenu;
	private Menu editMenu;
	private Menu helpMenu;

	private MenuItem fileMenuHeader;
	private MenuItem editMenuHeader;
	private MenuItem helpMenuHeader;

	private MenuItem fileNewItem;
	private MenuItem fileOpenItem;
	private MenuItem fileSaveItem;

	private MenuItem editCopyItem;
	private MenuItem editPasteItem;
	private MenuItem editDeleteItem;
	
	private MenuItem helpSearchItem;
	private MenuItem helpShowHotKeysItem;
	private MenuItem helpAboutItem;
	
	public MainMenu(Composite parent) {
		menuBar = new Menu(parent.getShell(), SWT.BAR);

		////////////////Creating of File menu/////////////////////
		fileMenu = new Menu(parent.getShell(), SWT.DROP_DOWN);
		
		fileMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
		fileMenuHeader.setMenu(fileMenu);
		fileMenuHeader.setText("&File");
		
		
		fileNewItem = new MenuItem(fileMenu, SWT.PUSH);
		fileNewItem.setText("&New");
		
		fileOpenItem = new MenuItem(fileMenu, SWT.PUSH);
		fileOpenItem.setText("&Open");
		
		fileSaveItem = new MenuItem(fileMenu, SWT.PUSH);
		fileSaveItem.setText("&Save");
		
		////////////////Creating of Edit menu/////////////////////
		editMenu = new Menu(parent.getShell(), SWT.DROP_DOWN);
		
		editMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
		editMenuHeader.setMenu(editMenu);
		editMenuHeader.setText("&Edit");
		
		editCopyItem = new MenuItem(editMenu, SWT.PUSH);
		editCopyItem.setText("&Copy");
		
		editPasteItem = new MenuItem(editMenu, SWT.PUSH);
		editPasteItem.setText("&Paste");
		
		editDeleteItem = new MenuItem(editMenu, SWT.PUSH);
		editDeleteItem.setText("&Delete");
		
		////////////////Creating of Help menu/////////////////////
		helpMenu = new Menu(parent.getShell(), SWT.DROP_DOWN);
		
		helpMenuHeader = new MenuItem(helpMenu, SWT.CASCADE);
		helpMenuHeader.setMenu(helpMenu);
		helpMenuHeader.setText("&Help");
		
		helpSearchItem = new MenuItem(helpMenu, SWT.PUSH);
		helpSearchItem.setText("&Search");
		
		helpShowHotKeysItem = new MenuItem(helpMenu, SWT.PUSH);
		helpShowHotKeysItem.setText("$Show hot keys");
		
		helpAboutItem = new MenuItem(helpMenu, SWT.PUSH);
		helpAboutItem.setText("&About");
	}
}
