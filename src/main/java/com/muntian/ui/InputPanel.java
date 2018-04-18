package com.muntian.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class InputPanel extends Composite {

	private static final String GROUP = "Group";
	private static final String NAME = "Name";
	private static final String SWT_TASK_DONE = "SWT task done";
	private Label labelName;
	private Text textName;
	private Label labelGroup;
	private Text textGroup;
	private Label labelSWTtaskDone;
	private Button checkBoxSWTtaskDone;
	
	public InputPanel(Composite parent, int style) {
		super(parent, style);
		createContent(parent);
		initAction();
	}

	public void createContent(Composite parent) {
		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout gridLayout = new GridLayout(2,false);
		gridLayout.verticalSpacing = 10;
		gridLayout.horizontalSpacing = 40;
		gridLayout.marginLeft = 12;
		gridLayout.marginTop = 10;
		
		setLayout(gridLayout);
		setBackground(parent.getShell().getBackground());
		
		labelName = new Label(this, SWT.NONE);
		labelName.setText(NAME);
		
		textName = new Text(this, SWT.BORDER);
		GridData gridData = new GridData();
		gridData.widthHint = 200;
		gridData.heightHint = 15;
		gridData.horizontalIndent = -37;
		textName.setLayoutData(gridData);
		
		labelGroup = new Label(this, SWT.NONE);
		labelGroup.setText(GROUP);
		
		textGroup = new Text(this, SWT.BORDER);
		gridData = new GridData();
		gridData.widthHint = 200;
		gridData.heightHint = 15;
		gridData.horizontalIndent = -37;
		textGroup.setLayoutData(gridData);
		
		labelSWTtaskDone = new Label(this, SWT.NONE);
		labelSWTtaskDone.setText(SWT_TASK_DONE);
		gridData = new GridData();
		gridData.verticalIndent = 10;
		labelSWTtaskDone.setLayoutData(gridData);
		
		checkBoxSWTtaskDone = new Button(this, SWT.CHECK);
		gridData = new GridData();
		gridData.horizontalIndent = 125;
		gridData.verticalIndent = 10;
		checkBoxSWTtaskDone.setLayoutData(gridData);
	}
	
	private void initAction() {
		System.out.println("initAction() of InputPanel");
		
	}
}
