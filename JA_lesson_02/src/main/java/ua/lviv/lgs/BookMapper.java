package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper {

	public static Book map(ResultSet result) throws SQLException {

		int id = result.getInt("id");
		String bookName = result.getString("book_name");
		String bookDescription = result.getString("book_description");
		double price = result.getDouble("price");
		String isbn = result.getString("isbn");

		return new Book(id, bookName, bookDescription, price, isbn);
	}
}
