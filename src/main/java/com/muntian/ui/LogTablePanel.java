package com.muntian.ui;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;

public class LogTablePanel extends Composite {

	private TableViewer tableViewer;
	
	public LogTablePanel(Composite parent, int style) {
		super(parent, style);
		createContent(parent);
	}

	public void createContent(Composite parent){
		FillLayout fillLayout = new FillLayout();
		setLayout(fillLayout);
		
		Label label = new Label(this, SWT.NONE);
		label.setText("TablePanel");
		
		tableViewer = new TableViewer(this, SWT.MULTI | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
//		createColumns(tableViewer);
		
		final Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
//		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
	}
}
