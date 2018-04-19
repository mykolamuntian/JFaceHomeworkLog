package com.muntian.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

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
		
		inputPanel = new InputPanel(this, SWT.NONE);
		GridData gridData = new GridData();
		gridData.horizontalIndent = 200;
		inputPanel.setLayoutData(gridData);

		buttonPanel = new ButtonPanel(this, SWT.NONE);
		gridData = new GridData();
		gridData.horizontalIndent = 10;
		inputPanel.setLayoutData(gridData);
	}

	public InputPanel getInputPanel() {
		return inputPanel;
	}

	public void setInputPanel(InputPanel inputPanel) {
		this.inputPanel = inputPanel;
	}
	
	
}
