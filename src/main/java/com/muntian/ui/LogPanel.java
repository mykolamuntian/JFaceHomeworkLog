package com.muntian.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class LogPanel extends Composite {

	public LogPanel(Composite parent, int style) {
		super(parent, SWT.BORDER);
		createContent(parent);
	}

	private void createContent(Composite parent) {
		SashForm sashForm = new SashForm(parent, SWT.NONE);
		createBodyLeft(sashForm);
		createBodyRight(sashForm);
		sashForm.setOrientation(SWT.HORIZONTAL);
		sashForm.setWeights(new int[] {1,1});
		
	}

	private void createBodyRight(Composite parent) {
		EditingPanel editingPanel = new EditingPanel(parent);
		editingPanel.setLayout(new FillLayout());	
	}

	private void createBodyLeft(Composite parent) {
		LogTablePanel logTablePanel = new LogTablePanel(parent);
		logTablePanel.setLayout(new FillLayout());
	}
 
	
}
