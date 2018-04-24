package com.muntian.ui;

import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.muntian.Main;
import com.muntian.exceptions.GroupNumberInputException;
import com.muntian.exceptions.NameInputException;
import com.muntian.logic.ModelTableData;
import com.muntian.services.InputVerifier;
import com.muntian.services.LogFileAccessManager;
import com.muntian.ui.table.HomeworkLogItem;

public class ButtonPanel extends Composite {

	private static final String INCORRECT_NAME_INPUT = "Incorrect name input";
	private static final String INCORRECT_GROUP_NUMBER_INPUT = "Incorrect group number input";
	private List<HomeworkLogItem> items;
	private HomeworkLogItem item;
	private InputPanel inputPanel;
	private LogFileAccessManager logFileAccessManager;

	private String fileName = "log.txt";

	private Button btnAdd;
	private Button btnSave;
	private Button btnDelete;
	private Button btnClear;

	public ButtonPanel(Composite parent, int style) {

		super(parent, style);
		createContent();
		initAction();
	}

	private void createContent() {

		RowLayout layout = new RowLayout();
		layout.type = SWT.HORIZONTAL;
		layout.spacing = 10;
		layout.marginTop = 20;
		this.setLayout(layout);

		btnAdd = new Button(this, SWT.PUSH);
		btnAdd.setText("Add");
		RowData rowData = new RowData();
		rowData.width = 70;
		btnAdd.setLayoutData(rowData);
		btnAdd.setToolTipText("Add a new student to the log");
		
		btnSave = new Button(this, SWT.PUSH);
		btnSave.setText("Save");
		btnSave.setLayoutData(rowData);
		btnSave.setToolTipText("Save current log state to a file");

		btnDelete = new Button(this, SWT.PUSH);
		btnDelete.setText("Delete");
		btnDelete.setLayoutData(rowData);
		btnDelete.setToolTipText("Remove selected student data from log");

		btnClear = new Button(this, SWT.PUSH);
		btnClear.setText("Clear");
		btnClear.setLayoutData(rowData);
		btnClear.setToolTipText("Clear input fields");
	}

	private void initAction() {

		System.out.println("initAction() of ButtonPanel");
		btnAdd.addListener(SWT.Selection, new ListenerForButtonAdd());
		btnSave.addListener(SWT.Selection, new ListenerForButtonSave());
		btnDelete.addListener(SWT.Selection, new ListenerForButtonDelete());
		btnClear.addListener(SWT.Selection, new ListenerForButtonClear());

		ModelTableData.getInstance().addObserver(MainWindow.getInstance().getTablePanel());
	}

	private boolean verifyInput(HomeworkLogItem item) {
		if (!InputVerifier.verifyInputName(item.getName())) {
			throw new NameInputException(INCORRECT_NAME_INPUT);
		}
		if (!InputVerifier.verifyInputGroupNumber(item.getGroup())) {
			throw new GroupNumberInputException(INCORRECT_GROUP_NUMBER_INPUT);
		}
		return true;
	}

	private class ListenerForButtonAdd implements Listener {

		public void handleEvent(Event event) {
			items = ModelTableData.getInstance().getItems();
			inputPanel = MainWindow.getInstance().getEditingPanel().getInputPanel();
			item = new HomeworkLogItem(inputPanel.getTextName().getText(), inputPanel.getTextGroup().getText(),
					inputPanel.getCheckBoxSWTtaskDone().getSelection());
			try {
				verifyInput(item);
				items.add(item);
				ModelTableData.getInstance().setItems(items);
			} catch (NameInputException | GroupNumberInputException e) {
				MessageDialog dialog = new MessageDialog(Main.getShell(), "Input error", null, e.getMessage(),
						MessageDialog.ERROR, new String[] { "Close" }, 0);
				dialog.open();
			}
		}
	}

	private class ListenerForButtonSave implements Listener {

		public void handleEvent(Event event) {
			logFileAccessManager = new LogFileAccessManager();
			logFileAccessManager.writeLogItemsToFile(fileName, ModelTableData.getInstance().getItems());
		}
	}

	private class ListenerForButtonDelete implements Listener {

		public void handleEvent(Event event) {
			items = ModelTableData.getInstance().getItems();
			List<HomeworkLogItem> selectedItems = MainWindow.getInstance().getTablePanel().getSelectedItems();
			for (HomeworkLogItem item : selectedItems) {
				items.remove(item);
			}
			ModelTableData.getInstance().setItems(items);
		}
	}

	private class ListenerForButtonClear implements Listener {

		public void handleEvent(Event event) {
			MainWindow.getInstance().getEditingPanel().getInputPanel().getTextName().setText("");
			MainWindow.getInstance().getEditingPanel().getInputPanel().getTextGroup().setText("");
			MainWindow.getInstance().getEditingPanel().getInputPanel().getCheckBoxSWTtaskDone().setSelection(false);
		}
	}
}
