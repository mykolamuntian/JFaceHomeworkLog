package com.muntian.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import com.muntian.logic.ModelTableData;
import com.muntian.logic.Observer;
import com.muntian.ui.table.HomeworkContentProvider;
import com.muntian.ui.table.HomeworkLabelProvider;
import com.muntian.ui.table.HomeworkLogItem;

public class TablePanel extends Composite implements Observer {

	private List<HomeworkLogItem> items;

	private List<HomeworkLogItem> selectedItems;
	private TableViewer tableViewer;
	// private HomeworkLogItem[] selectedLines;

	public TablePanel(Composite parent, int style) {
		super(parent, style);
		createContent(parent);

		initListeners();
	}

	public void createContent(Composite parent) {
		FillLayout fillLayout = new FillLayout();
		setLayout(fillLayout);

		tableViewer = new TableViewer(this, SWT.MULTI | SWT.FULL_SELECTION | SWT.BORDER);

		TableLayout tableLayout = new TableLayout();
		tableLayout.addColumnData(new ColumnWeightData(50, true));
		tableLayout.addColumnData(new ColumnWeightData(15, true));
		tableLayout.addColumnData(new ColumnWeightData(25, true));

		tableViewer.getTable().setLayout(tableLayout);
		tableViewer.getTable().setLinesVisible(true);
		tableViewer.getTable().setHeaderVisible(true);

		TableViewerColumn column1 = new TableViewerColumn(tableViewer, SWT.LEFT);
		column1.getColumn().setText("Name");

		TableViewerColumn column2 = new TableViewerColumn(tableViewer, SWT.RIGHT);
		column2.getColumn().setText("Group");

		TableViewerColumn column3 = new TableViewerColumn(tableViewer, SWT.LEFT);
		column3.getColumn().setText("SWT done");

		tableViewer.setContentProvider(new HomeworkContentProvider());

		tableViewer.setLabelProvider(new HomeworkLabelProvider());

		items = new ArrayList<HomeworkLogItem>();

//		items.add(new HomeworkLogItem("Вася", "1", true));
//		items.add(new HomeworkLogItem("Петя", "1", false));
//		items.add(new HomeworkLogItem("Толик", "2", false));
//		items.add(new HomeworkLogItem("Толик", "2", false));
//		items.add(new HomeworkLogItem("Толик", "2", false));
//		items.add(new HomeworkLogItem("Толик", "2", false));
//		items.add(new HomeworkLogItem("Толик", "2", false));
//		items.add(new HomeworkLogItem("Толик", "2", false));
//		items.add(new HomeworkLogItem("Толик", "2", false));
		
		
		items = ModelTableData.getInstance().getItems();

		tableViewer.setInput(items);

	}

	public void update(List<HomeworkLogItem> items) {
		tableViewer.setInput(items);
	}

	public List<HomeworkLogItem> getItems() {
		return items;
	}

	public List<HomeworkLogItem> getSelectedItems() {
		return selectedItems;
	}

	private void initListeners() {
		tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selectedLines = (IStructuredSelection) event.getSelection();
				selectedItems = selectedLines.toList();
			}
		});
	}
}
