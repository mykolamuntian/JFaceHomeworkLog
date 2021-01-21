package com.muntian.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.muntian.ui.table.HomeworkLogItem;

public class LogFileAccessManager {

	private Type itemsListType = new TypeToken<List<HomeworkLogItem>>() {
	}.getType();

	public LogFileAccessManager() {
		super();
	}

	public void writeLogItemsToFile(String fileName, List<HomeworkLogItem> items) {
		Gson gson = new Gson();
		String jsonStr = gson.toJson(items);
		System.out.println(jsonStr);
		try (Writer writer = new FileWriter(fileName)) {
			writer.write(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	public static void writeStudentToFile(Student student) {
//        try (Writer writer = new FileWriter(student.getName() + ".txt")) {
//            writer.write(student.getName() + System.lineSeparator());
//            writer.write(student.getLastName() + System.lineSeparator());
//            for (int i = 0; i < student.getMarks().length; i++) {
//                writer.write(student.getMarks()[i] + System.lineSeparator());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

	public List<HomeworkLogItem> readLogItemsFromFile(String fileName) {
		List<HomeworkLogItem> items;
		try (Reader reader = new FileReader(fileName)) {
			BufferedReader bufferedReader = new BufferedReader(reader);
			String jsonStr = bufferedReader.readLine();
			if (jsonStr == null) {
				items = getDefaultLogItems();
			} else {
				items = new Gson().fromJson(jsonStr, itemsListType);
			}
		} catch (FileNotFoundException e) {
			items = getDefaultLogItems();
		} catch (IOException e) {
			items = getDefaultLogItems();
		}
		return items;
	}
	
	private List<HomeworkLogItem> getDefaultLogItems() {
		return new ArrayList<HomeworkLogItem>();
	}
}
