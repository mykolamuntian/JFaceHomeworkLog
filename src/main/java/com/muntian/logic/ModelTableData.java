package com.muntian.logic;

import java.util.List;

import com.muntian.ui.table.HomeworkLogItem;

public class ModelTableData implements Observable {
	private List<Observer> observers;

	private List<HomeworkLogItem> items;

	public ModelTableData() {
		super();
	}

	public ModelTableData(List<HomeworkLogItem> items) {
		super();
		this.items = items;
	}

	public void addObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	public void notifyObservers(List<Observer> observers) {
		for (Observer observer : observers) {
			observer.update(items);
		}
	}

	public List getItems() {
		return items;
	}

	public void setItems(List<HomeworkLogItem> items) {
		this.items = items;
	}
}
