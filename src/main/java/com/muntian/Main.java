package com.muntian;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.muntian.ui.MainWindow;

public class Main {
	private static Display display;
	private static Shell shell;

	static {
		display = new Display();
		shell = new Shell(display, SWT.CLOSE | SWT.TITLE | SWT.MIN);
	}

	public static void main(String[] args) {
		
		MainWindow mainWindow = new MainWindow(shell);
		mainWindow.addMenuBar();
		mainWindow.setBlockOnOpen(true);
		mainWindow.open();
		
	}
}
