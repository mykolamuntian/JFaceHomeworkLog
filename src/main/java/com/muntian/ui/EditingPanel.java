package com.muntian.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class EditingPanel extends Composite {
	
	private ButtonPanel buttonPanel;
	private InputPanel inputPanel;
	
	public EditingPanel(Composite parent, int style) {
		super(parent, style);
		createContent(parent);
	}

	public void createContent(Composite parent) {
		
		GridLayout gridLayout = new GridLayout(1,true);
		setLayout(gridLayout);
		
		Label label = new Label(this, SWT.BORDER);
		label.setText("EditingPanel");
		
		inputPanel = new InputPanel(this, SWT.BORDER);

		buttonPanel = new ButtonPanel(this, SWT.BORDER);
	}
}
