package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.List;

public class Author {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private int birthdayDate;

	public Author(int id, String firstName, String lastName, String email, String address, int birthdayDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.birthdayDate = birthdayDate;
	}

	public Author(String firstName, String lastName, String email, String address, int birthdayDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.birthdayDate = birthdayDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(int birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	@Override
	public String toString() {
		return id + " --> Імя - " + "\"" + firstName + "\"" + ", Прізвище - " + "\"" + lastName + "\"" + ", email - " + email
				+ ", адреса - " + "\"" + address + "\"" + ", рік народження - " + birthdayDate;
	}
	
	public static List<Author> createDefaultData() {
		List<Author> authorsList = new ArrayList<>();
		authorsList.add(new Author("Джеф", "Кінні", "d.kinns@mail.com", "Форт Вашингтон, Меріленд, США", 1971));
		authorsList.add(new Author("Маріша", "Пессл", "m.pessl@mail.com", "Кларкстон, Мічіган, США", 1977));
		authorsList.add(new Author("Суі", "Ісіда", "s.isida@mail.com", "Фукуока, Япония", 1985));
		authorsList.add(new Author("Умберто", "Еко", "u.eko@mail.com", "Алессандрiя, Iталiя", 1932));
		authorsList
				.add(new Author("Олексій", "Васильєв", "o.vasilev@mail.com", "Санкт-Петербург, Россия", 1939));
		return authorsList;
	} 

}
