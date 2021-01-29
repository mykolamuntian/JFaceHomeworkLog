package com.muntian.ui.table;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class HomeworkContentProvider implements IStructuredContentProvider {

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {		
	}

	public Object[] getElements(Object inputElement) {
		return ((List<HomeworkLogItem>) inputElement).toArray();
	}

}
