package com.muntian.ui.table;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

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

	private ResourceManager resourceManager = new LocalResourceManager(JFaceResources.getResources());

	public Image getColumnImage(Object element, int columnIndex) {
		if (columnIndex == 2) {
			if (((HomeworkLogItem) element).isDone()) {
				return resourceManager.createImage(getImageDescriptor(CheckedState.CHECKED.getValue()));
			}
			return resourceManager.createImage(getImageDescriptor(CheckedState.UNCHECKED.getValue()));
		}
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
	      return "";
	    }
	    return "";
	}
	
	private ImageDescriptor getImageDescriptor(String imageFile) {
		Image img = new Image(Display.getCurrent(), imageFile);
		return ImageDescriptor.createFromImage(img);
	}

}
