package com.muntian.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.muntian.ui.table.HomeworkLogItem;

public class ModelTableData implements Observable {
	private List<Observer> observers = new ArrayList<Observer>();

	private List<HomeworkLogItem> items;
	Type itemsListType = new TypeToken<List<HomeworkLogItem>>() {}.getType();
	private static ModelTableData instance;
	
	private ModelTableData() {
		super();
		initTableModel();
	}

	public static ModelTableData getInstance() {
		if(instance==null) {
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
	
	private void initTableModel() {
		String jsonStr = readItemsFromFile("log.txt");
		items = new Gson().fromJson(jsonStr, itemsListType);
	}
	
	private String readItemsFromFile(String fileName) {
		try(Reader reader = new FileReader(fileName)){
			
			BufferedReader bufferedReader = new BufferedReader(reader);
			
			return bufferedReader.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
//	public static Student readStudentFromFile(String fileName) {
//        Student student = new Student();
//        try (Reader reader = new FileReader(fileName)) {
//
//            BufferedReader bufferedReader = new BufferedReader(reader);
//
//            String line;
//            List<String> lines = new ArrayList<>();
//            //Write each line from the file to array list
//            while ((line = bufferedReader.readLine()) != null) {
//                lines.add(line);
//            }
//            //Assembling of a student field by field
//            student.setName(lines.get(NAME_OF_THE_STUDENT));
//            student.setLastName(lines.get(LAST_NAME_OF_THE_STUDENT));
//            //Create an array of marks and set it to student
//            int[] marks = new int[lines.size() - QUANTITY_OF_FIELDS_BEFORE_MARKS];
//            for (int i = 0; i < marks.length; i++) {
//                marks[i] = parseInt(lines.get(QUANTITY_OF_FIELDS_BEFORE_MARKS + i));
//            }
//            student.setMarks(marks);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return student;
//    }
}
