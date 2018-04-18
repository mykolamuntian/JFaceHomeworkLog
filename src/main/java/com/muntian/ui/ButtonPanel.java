package com.muntian.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class ButtonPanel extends Composite {

	private Button btnNew;
	private Button btnSave;
	private Button btnDelete;
	private Button btnCancel;

	public ButtonPanel(Composite parent, int style) {
		super(parent, style);
		createContent();
		initAction();
	}


	private void createContent() {
		RowLayout layout = new RowLayout();
		layout.type = SWT.HORIZONTAL;
		layout.spacing = 10;
		this.setLayout(layout);
		
//		Label label = new Label(this, SWT.BORDER);
//		label.setText("ButtonPanel");
		
		btnNew = new Button(this, SWT.PUSH);
		btnNew.setText("New");
		RowData rowData = new RowData();
		rowData.width = 70;
		btnNew.setLayoutData(rowData);

		btnSave = new Button(this, SWT.PUSH);
		btnSave.setText("Save");
		btnSave.setLayoutData(rowData);
		
		btnDelete = new Button(this, SWT.PUSH);
		btnDelete.setText("Delete");
		btnDelete.setLayoutData(rowData);
		
		btnCancel = new Button(this, SWT.PUSH);
		btnCancel.setText("Cancel");
		btnCancel.setLayoutData(rowData);

	}
	
	private void initAction() {
		System.out.println("initAction() of ButtonPanel");
	}
}
