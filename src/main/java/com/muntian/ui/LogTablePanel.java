package com.muntian.ui;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class LogTablePanel extends Composite {
	private TableViewer tableViewer;

	public LogTablePanel(Composite parent) {
		super(parent, SWT.NONE);
	}

}
