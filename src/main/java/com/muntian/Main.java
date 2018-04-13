package com.muntian;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Main {

	private static final String TITLE_OF_APP = "JFace homework log";

	private static Display display;
	private static Shell shell;

	static {
		display = new Display();
		shell = new Shell(display, SWT.CLOSE | SWT.TITLE);
	}

	public static void main(String[] args) {
		shell.setText(TITLE_OF_APP);

//		GridLayout gridLayout = new GridLayout();
//		shell.setLayout(gridLayout);

		

		shell.setLocation(750, 200);
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
