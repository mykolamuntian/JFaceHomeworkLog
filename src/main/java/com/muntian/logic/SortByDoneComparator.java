package com.muntian.logic;

import java.util.Comparator;

import com.muntian.ui.table.HomeworkLogItem;

public class SortByDoneComparator implements Comparator<HomeworkLogItem> {

	@Override
	public int compare(HomeworkLogItem o1, HomeworkLogItem o2) {
		int res;
		if(o1.isDone()==o2.isDone()) {
		res = 0;
		}else if(o1.isDone()) {
			res = -1;
		}else {
			res = 1;
		}
		return res;
	}

}
