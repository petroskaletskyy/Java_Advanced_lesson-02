package ua.lviv.lgs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import ua.lviv.lgs.Author;

public class Application {

	public static int menu() {
		System.out.println();
		System.out.println("****СТАНДАРТНІ ДАНІ****");
		System.out.println("Введіть 11 для того, щоб завантажити стандартний набір даних");
		System.out.println("****БАЗА КНИГ****");
		System.out.println("Введіть 21 для того, щоб додати книгу в базу");
		System.out.println("Введіть 22 для того, щоб видалити книгу з бази по ід");
		System.out.println("Введіть 23 для того, щоб додати додаткові дані про книгу по ід");
		System.out.println("Введіть 24 для того, щоб вивести всі книги");
		System.out.println("****БАЗА АВТОРІВ****");
		System.out.println("Введіть 31 для того, щоб додати автора в базу");
		System.out.println("Введіть 32 для того, щоб видалити автора з бази по ід");
		System.out.println("Введіть 33 для того, щоб додати додаткові дані про автора по ід");
		System.out.println("Введіть 34 для того, щоб вивести всіх авторів");
		System.out.println("****БАЗА КАТЕГОРІЙ КНИГ****");
		System.out.println("Введіть 41 для того, щоб додати категорію книги в базу");
		System.out.println("Введіть 42 для того, щоб видалити категорію книги з бази по ід");
		System.out.println("Введіть 43 для того, щоб додати додаткові дані про категорію книги по ід");
		System.out.println("Введіть 44 для того, щоб вивести всі категорії книг");
		System.out.println("****ВИХІД З ПРОГРАМИ****");
		System.out.println("Введіть 0 для того, щоб вийти");
		System.out.println();

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Зробіть Ваш вибір: ");
		int menuChoise = scanner.nextInt();

		return menuChoise;
	}

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException {

		AuthorDAO authorDAO = new AuthorDAO(ConnectionUtils.openConnection());
		BookDAO bookDAO = new BookDAO(ConnectionUtils.openConnection());
		CategoryBookDAO categoryBookDAO = new CategoryBookDAO(ConnectionUtils.openConnection());

		while (true) {
			switch (menu()) {

			case 11: {
				List<Author> authorsList = Author.createDefaultData();

				authorsList.stream().forEach(author -> {
					try {
						authorDAO.insert(author);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				});

				authorDAO.readAll().forEach(System.out::println);
				System.out.println("************************************************");
				System.out.println();

				List<Book> booklList = Book.createDefaultData();

				booklList.stream().forEach(book -> {
					try {
						bookDAO.insert(book);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				});

				bookDAO.readAll().forEach(System.out::println);
				System.out.println("************************************************");
				System.out.println();

				List<CategoryBook> categoryBookList = CategoryBook.createDefaultData();

				categoryBookList.stream().forEach(categoryBook -> {
					try {
						categoryBookDAO.insert(categoryBook);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				});

				categoryBookDAO.readAll().forEach(System.out::println);
				System.out.println("************************************************");
				System.out.println();

				break;
			}

			case 21: {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Введіть назву книги:");
				String bookName = reader.readLine();
				System.out.println("Введіть опис книги:");
				String bookDescription = reader.readLine();;
				System.out.println("Введіть ціну книги (в форматі 111.11):");
				Double price = Double.parseDouble(reader.readLine());
				System.out.println("Введіть ISBN книги:");
				String isbn = reader.readLine();
				Book book = new Book(bookName, bookDescription, price, isbn);
				bookDAO.insert(book);
				break;
			}

			case 22: {
				bookDAO.readAll().forEach(System.out::println);
				System.out.println("Введіть ід для видалення:");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				int id = sc.nextInt();
				bookDAO.delete(id);
				
				break;
			}

			case 23: {
				System.out.println("Введіть ід для пошуку:");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				int id = sc.nextInt();
				Book bookFromDB = bookDAO.read(id);
				System.out.println(bookFromDB.toString());
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Введіть дані, якщо хочете змінити назву книги:");
				String bookName = reader.readLine();
				System.out.println("Введіть дані, якщо хочете змінити опис книги:");
				String bookDescription = reader.readLine();
				System.out.println("Введіть дані, якщо хочете змінити ціну книги(в форматі 111.11):");
				double price = Double.parseDouble(reader.readLine());
				System.out.println("Введіть дані, якщо хочете змінити ISBN книги:");
				String isbn = reader.readLine();
				
				if (bookName.equals("")) {
					bookFromDB.setBookName(bookFromDB.getBookName());
				} else {
					bookFromDB.setBookName(bookName);
				}
				
				if (bookDescription.equals("")) {
					bookFromDB.setBookDescription(bookFromDB.getBookDescription());
				} else {
					bookFromDB.setBookDescription(bookDescription);
				}
				
				if (price == 0.0) {
					bookFromDB.setPrice(bookFromDB.getPrice());
				} else {
					bookFromDB.setPrice(price);
				}
				
				if (isbn.equals("")) {
					bookFromDB.setIsbn(bookFromDB.getIsbn());
				} else {
					bookFromDB.setIsbn(isbn);
				}
				
				bookDAO.update(bookFromDB);
				break;
			}

			case 24: {
				bookDAO.readAll().forEach(System.out::println);
				break;
			}

			case 31: {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Введіть імя автора:");
				String firstName = reader.readLine();
				System.out.println("Введіть прізвище автора:");
				String lastName = reader.readLine();
				System.out.println("Введіть мейл автора:");
				String email = reader.readLine();
				System.out.println("Введіть адресу автора:");
				String address = reader.readLine();
				System.out.println("Введіть рік народження автора:");
				int birthdayDate = Integer.parseInt(reader.readLine());
				Author author = new Author(firstName, lastName, email, address, birthdayDate);
				authorDAO.insert(author);
				break;
			}

			case 32: {
				authorDAO.readAll().forEach(System.out::println);
				System.out.println("Введіть ід для видалення:");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				int id = sc.nextInt();
				authorDAO.delete(id);
				
				break;
			}
			case 33: {
				System.out.println("Введіть ід для пошуку:");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				int id = sc.nextInt();
				Author authorFromDB = authorDAO.read(id);
				System.out.println(authorFromDB.toString());
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Введіть дані, якщо хочете змінити імя автора:");
				String firstName = reader.readLine();
				System.out.println("Введіть дані, якщо хочете змінити прізвище автора:");
				String lastName = reader.readLine(); 
				System.out.println("Введіть дані, якщо хочете змінити мейл автора:");
				String email = reader.readLine();
				System.out.println("Введіть дані, якщо хочете змінити адресу автора:");
				String address = reader.readLine();
				System.out.println("Введіть дані, якщо хочете змінити рік народження автора:");
				int year = Integer.parseInt(reader.readLine());
				if (firstName.equals("")) {
					authorFromDB.setFirstName(authorFromDB.getFirstName());
				} else {
					authorFromDB.setFirstName(firstName);
				}
				
				if (lastName.equals("")) {
					authorFromDB.setLastName(authorFromDB.getLastName());
				} else {
					authorFromDB.setLastName(lastName);
				}
				
				if (email.equals("")) {
					authorFromDB.setEmail(authorFromDB.getEmail());
				} else {
					authorFromDB.setEmail(email);
				}
				
				if (address.equals("")) {
					authorFromDB.setAddress(authorFromDB.getAddress());
				} else {
					authorFromDB.setAddress(address);
				}
				
				if (year == 0) {
					authorFromDB.setBirthdayDate(authorFromDB.getBirthdayDate());
				} else {
					authorFromDB.setBirthdayDate(year);
				}
				
				authorDAO.update(authorFromDB);
				break;
			}

			case 34: {
				authorDAO.readAll().forEach(System.out::println);
				break;
			}

			case 41: {
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				System.out.println("Введіть назву жанру книги:");
				String categoryName = sc.nextLine();
				CategoryBook categoryBook = new CategoryBook(categoryName);
				categoryBookDAO.insert(categoryBook);
				
				break;
			}

			case 42: {
				categoryBookDAO.readAll().forEach(System.out::println);
				System.out.println("Введіть ід для видалення:");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				int id = sc.nextInt();
				categoryBookDAO.delete(id);
				
				break;
			}

			case 43: {
				System.out.println("Введіть ід для пошуку:");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				int id = sc.nextInt();
				CategoryBook categoryBookFromDB = categoryBookDAO.read(id);
				System.out.println(categoryBookFromDB.toString());
				System.out.println("Введіть дані, якщо хочете змінити жанр книги:");
				String categoryName = sc.nextLine();
				
				if (categoryName.equals("")) {
					categoryBookFromDB.setCategoryName(categoryBookFromDB.getCategoryName());
				} else {
					categoryBookFromDB.setCategoryName(categoryName);
				}
				
				categoryBookDAO.update(categoryBookFromDB);
				
				break;
			}

			case 44: {
				categoryBookDAO.readAll().forEach(System.out::println);
				break;
			}

			case 0: {
				System.out.println("Дякуємо, що скористалися нашою бібліотекою. Всього найкращого\n");
				System.exit(0);
				break;
			}

			default: {
				System.out.println("Такий пункт в меню відсутній!");
				break;
			}
			}
		}
	}

}
