package com.muntian.ui;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
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

	public void addMenuBar() {
		super.addMenuBar();
	}

	@Override
	protected Control createContents(Composite parent) {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;

		SashForm sashForm = new SashForm(parent, SWT.NONE);
		sashForm.setOrientation(SWT.HORIZONTAL);
		sashForm.setSashWidth(5);

		GridData gridData = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL);
		sashForm.setLayoutData(gridData);
		sashForm.setLayout(gridLayout);
		
		TablePanel logTablePanel = new TablePanel(sashForm, SWT.BORDER);
		EditingPanel editingPanel = new EditingPanel(sashForm,SWT.BORDER);
		return parent;
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
		shell.setLocation(600, 300);
		shell.setSize(680, 240);
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
