package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.List;

public class CategoryBook {

	private int id;
	private String categoryName;

	public CategoryBook(int id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}

	public CategoryBook(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return id + " --> Назва категорії - " + "\"" + categoryName + "\"";
	}

	public static List<CategoryBook> createDefaultData() {
		List<CategoryBook> categoryBookList = new ArrayList<>();
		categoryBookList.add(new CategoryBook("Художня література"));
		categoryBookList.add(new CategoryBook("Комікси"));
		categoryBookList.add(new CategoryBook("Фентезі"));
		categoryBookList.add(new CategoryBook("Пригодника література"));
		categoryBookList.add(new CategoryBook("Детектив"));
		return categoryBookList;
	}

}
