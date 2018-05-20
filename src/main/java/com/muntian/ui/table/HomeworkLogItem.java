package com.muntian.ui.table;

public class HomeworkLogItem {

	private String name;
	private String group;
	private boolean done;


	public HomeworkLogItem(String name, String group, boolean done) {
		super();
		this.name = name;
		this.group = group;
		this.done = done;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
}
