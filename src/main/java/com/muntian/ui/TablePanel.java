package com.muntian.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import com.muntian.ui.table.HomeworkContentProvider;
import com.muntian.ui.table.HomeworkLabelProvider;
import com.muntian.ui.table.HomeworkLogItem;

public class TablePanel extends Composite {

	private List<HomeworkLogItem> items;
	
	public TablePanel(Composite parent, int style) {
		super(parent, style);
		createContent(parent);
	}

	public void createContent(Composite parent){
		FillLayout fillLayout = new FillLayout();
		setLayout(fillLayout);
		
//		Label label = new Label(this, SWT.NONE);
//		label.setText("TablePanel");
		
		final TableViewer tableViewer = new TableViewer(this, SWT.MULTI | SWT.FULL_SELECTION | SWT.BORDER);

		TableLayout tableLayout = new TableLayout();
		tableLayout.addColumnData(new ColumnWeightData(50,true));
		tableLayout.addColumnData(new ColumnWeightData(15,true));
		tableLayout.addColumnData(new ColumnWeightData(35,true));
		
		tableViewer.getTable().setLayout(tableLayout);
		tableViewer.getTable().setLinesVisible(true);
		tableViewer.getTable().setHeaderVisible(true);
		
		TableViewerColumn column1 = new TableViewerColumn(tableViewer, SWT.LEFT);
		column1.getColumn().setWidth(200);
		column1.getColumn().setText("Name");
		
		TableViewerColumn column2 = new TableViewerColumn(tableViewer, SWT.RIGHT);
		column2.getColumn().setWidth(80);
		column2.getColumn().setText("Group");
		
		TableViewerColumn column3 = new TableViewerColumn(tableViewer, SWT.LEFT);
		column3.getColumn().setWidth(110);
		column3.getColumn().setText("SWT done");
		
		tableViewer.setContentProvider(new HomeworkContentProvider());
		
		tableViewer.setLabelProvider(new HomeworkLabelProvider());
		
		items = new ArrayList<HomeworkLogItem>();
		
		items.add(new HomeworkLogItem("Вася", "1", true));
		items.add(new HomeworkLogItem("Петя", "1", false));
		items.add(new HomeworkLogItem("Толик", "2", false));
		items.add(new HomeworkLogItem("Толик", "2", false));
		items.add(new HomeworkLogItem("Толик", "2", false));
		items.add(new HomeworkLogItem("Толик", "2", false));
		items.add(new HomeworkLogItem("Толик", "2", false));
		items.add(new HomeworkLogItem("Толик", "2", false));
		items.add(new HomeworkLogItem("Толик", "2", false));
		
		tableViewer.setInput(items);
	}
}
