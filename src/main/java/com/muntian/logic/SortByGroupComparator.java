package com.muntian.logic;

import java.util.Comparator;

import com.muntian.ui.table.HomeworkLogItem;

public class SortByGroupComparator implements Comparator<HomeworkLogItem> {

	@Override
	public int compare(HomeworkLogItem o1, HomeworkLogItem o2) {
		int res = String.CASE_INSENSITIVE_ORDER.compare(o1.getGroup(), o2.getGroup());
		if (res == 0) {
			res = String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName());
		}
		return res;
	}

}
