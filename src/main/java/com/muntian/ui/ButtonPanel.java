package com.muntian.ui;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.google.gson.Gson;
import com.mintian.services.LogFileAccessManager;
import com.muntian.logic.ModelTableData;
import com.muntian.ui.table.HomeworkLogItem;

public class ButtonPanel extends Composite {

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

		btnSave = new Button(this, SWT.PUSH);
		btnSave.setText("Save");
		btnSave.setLayoutData(rowData);

		btnDelete = new Button(this, SWT.PUSH);
		btnDelete.setText("Delete");
		btnDelete.setLayoutData(rowData);

		btnClear = new Button(this, SWT.PUSH);
		btnClear.setText("Clear");
		btnClear.setLayoutData(rowData);
	}

	private void initAction() {

		System.out.println("initAction() of ButtonPanel");
		btnAdd.addListener(SWT.Selection, new ListenerForButtonAdd());
		btnSave.addListener(SWT.Selection, new ListenerForButtonSave());
		btnDelete.addListener(SWT.Selection, new ListenerForButtonDelete());
		btnClear.addListener(SWT.Selection, new ListenerForButtonClear());

		ModelTableData.getInstance().addObserver(MainWindow.getInstance().getTablePanel());
	}

	private void writeLogToFile(String json) {

		try (Writer writer = new FileWriter("log.txt")) {
			writer.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class ListenerForButtonAdd implements Listener {

		public void handleEvent(Event event) {
			items = ModelTableData.getInstance().getItems();
			inputPanel = MainWindow.getInstance().getEditingPanel().getInputPanel();
			item = new HomeworkLogItem(inputPanel.getTextName().getText(), inputPanel.getTextGroup().getText(),
					inputPanel.getCheckBoxSWTtaskDone().getSelection());
			items.add(item);
			ModelTableData.getInstance().setItems(items);
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
