package com.muntian.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.muntian.logic.ModelTableData;

public class ButtonPanel extends Composite {

	private ModelTableData modelTableData;

	private Button btnNew;
	private Button btnSave;
	private Button btnDelete;
	private Button btnCancel;

	public ButtonPanel(Composite parent, int style) {
		super(parent, style);
		modelTableData = new ModelTableData();
		createContent();
		initAction();
	}

	private void createContent() {
		RowLayout layout = new RowLayout();
		layout.type = SWT.HORIZONTAL;
		layout.spacing = 10;
		layout.marginTop = 20;
		this.setLayout(layout);

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
		btnNew.addListener(SWT.Selection, new ListenerForButtonNew());
		btnSave.addListener(SWT.Selection, new ListenerForButtonSave());
		btnDelete.addListener(SWT.Selection, new ListenerForButtonDelete());
		btnCancel.addListener(SWT.Selection, new ListenerForButtonCancel());
	}
	
	private class ListenerForButtonNew implements Listener{

		public void handleEvent(Event event) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class ListenerForButtonSave implements Listener{

		public void handleEvent(Event event) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class ListenerForButtonDelete implements Listener{

		public void handleEvent(Event event) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class ListenerForButtonCancel implements Listener{

		public void handleEvent(Event event) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
