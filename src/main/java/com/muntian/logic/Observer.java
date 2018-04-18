package com.muntian.logic;

import java.util.List;

import com.muntian.ui.table.HomeworkLogItem;

public interface Observer {
	void update (List<HomeworkLogItem> items);
}
