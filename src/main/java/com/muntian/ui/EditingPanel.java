package com.muntian.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class EditingPanel extends Composite {
	
	private static final String GROUP = "Group";
	private static final String NAME = "Name";
	private static final String SWT_TASK_DONE = "SWT task done";
	private Label labelName;
	private Text textName;
	private Label labelGroup;
	private Text textGroup;
	private Label labelSWTtaskDone;
	private Button checkBoxSWTtaskDone;
	private Button btnNew;
	private Button btnSave;
	private Button btnDelete;
	private Button btnCancel;
	
	public EditingPanel(Composite parent) {
		super(parent, SWT.NONE);
		createContent(parent);
		initActions();
	}

	public void createContent(Composite parent) {
		System.out.println("createContent()");
		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout gridLayout = new GridLayout(4, true);
//		gridLayout.verticalSpacing = 20;
//		gridLayout.horizontalSpacing = 18;
		setLayout(gridLayout);
		setBackground(parent.getShell().getBackground());
		
		labelName = new Label(this, SWT.NONE);
		labelName.setText(NAME);
		
		textName = new Text(this, SWT.BORDER);
		
		labelGroup = new Label(this, SWT.NONE);
		labelGroup.setText(GROUP);
		
		textGroup = new Text(this, SWT.BORDER);
		
		labelSWTtaskDone = new Label(this, SWT.NONE);
		labelSWTtaskDone.setText(SWT_TASK_DONE);
		
		checkBoxSWTtaskDone = new Button(this, SWT.CHECK);
	}
	
	private void initActions() {
		System.out.println("initActions()");
	}
	
}
