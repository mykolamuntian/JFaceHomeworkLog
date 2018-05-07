package com.muntian;

import com.muntian.ui.MainWindow;

public class Main {

	public static void main(String[] args) {
		MainWindow mainWindow = MainWindow.getInstance();
		mainWindow.addMenuBar();
		mainWindow.setBlockOnOpen(true);
		mainWindow.open();
	}

}
