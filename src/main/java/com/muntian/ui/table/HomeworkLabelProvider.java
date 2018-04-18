package com.muntian.ui.table;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

public class HomeworkLabelProvider implements ITableLabelProvider {

	public void addListener(ILabelProviderListener listener) {
	}

	public void dispose() {		
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
	}

	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	public String getColumnText(Object element, int columnIndex) {
		HomeworkLogItem item = (HomeworkLogItem) element;
	    switch (columnIndex) {
	    case 0:
	      return item.getName();
	    case 1:
	      return item.getGroup();
	    case 2:
	      return String.valueOf(item.isDone());
	    }
	    return "";
	}

}
