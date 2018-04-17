package com.muntian.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class LogPanel extends Composite {

	public LogPanel(Composite parent, int style) {
		super(parent, style);
		createContent(parent);
	}

	private void createContent(Composite parent) {
		initLayout(parent);

		SashForm sashForm = new SashForm(parent, SWT.NONE);
//		EditingPanel editingPanel = new EditingPanel(sashForm);
//		LogTablePanel logTablePanel = new LogTablePanel(sashForm);
		createBodyLeft(sashForm);
		createBodyRight(sashForm);
		sashForm.setOrientation(SWT.HORIZONTAL);
		sashForm.setSashWidth(10);
//		sashForm.setWeights(new int[] { 2, 5 });

	}

	private void initLayout(Composite parent) {
		FillLayout fillLayout = new FillLayout();
		fillLayout.type = SWT.HORIZONTAL;
		fillLayout.marginHeight = 5;
		fillLayout.marginWidth = 5;
		parent.setLayout(fillLayout);
	}

	private void createBodyRight(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setText("EditingPanel place");
//		EditingPanel editingPanel = new EditingPanel(parent);
//		editingPanel.setLayout(new FillLayout());
	}

	private void createBodyLeft(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setText("LogTablePanel place");
//		LogTablePanel logTablePanel = new LogTablePanel(parent);
//		logTablePanel.setLayout(new FillLayout());
	}

//	public static void main(String[] args) {
//		Display display = new Display();
//		Shell shell = new Shell(display, SWT.CLOSE | SWT.TITLE | SWT.MIN);
//
//		// GridLayout gridLayout = new GridLayout();
//		// shell.setLayout(gridLayout);
//
//		FillLayout fillLayout = new FillLayout();
//		fillLayout.marginHeight = 5;
//		fillLayout.marginWidth = 5;
//		shell.setLayout(fillLayout);
//
//		new LogPanel(shell, SWT.BORDER);
//
//		shell.setLocation(750, 200);
//		shell.setSize(600, 600);
//		shell.pack();
//		shell.open();
//		while (!shell.isDisposed()) {
//			if (!display.readAndDispatch())
//				display.sleep();
//		}
//		display.dispose();
//
//	}
}
