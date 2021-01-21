package com.muntian.logic;

import java.util.ArrayList;
import java.util.List;

import com.muntian.services.LogFileAccessManager;
import com.muntian.ui.table.HomeworkLogItem;

public class ModelTableData implements Observable {
	private List<Observer> observers = new ArrayList<Observer>();
	private List<HomeworkLogItem> items;
	private LogFileAccessManager logFileAccessManager;
	private String fileName = "log.json";
	private static ModelTableData instance;

	private ModelTableData() {
		super();
		initTableModel(fileName);
	}

	public static ModelTableData getInstance() {
		if (instance == null) {
			instance = new ModelTableData();
		}
		return instance;
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

	public List<HomeworkLogItem> getItems() {
		return items;
	}

	public void setItems(List<HomeworkLogItem> items) {
		this.items = items;
		notifyObservers(observers);
	}

	private void initTableModel(String fileName) {
		logFileAccessManager = new LogFileAccessManager();
		items = logFileAccessManager.readLogItemsFromFile(fileName);
	}

}
