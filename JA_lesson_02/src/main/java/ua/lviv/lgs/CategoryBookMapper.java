package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryBookMapper {

	public static CategoryBook map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String categoryName = result.getString("category_name");

		return new CategoryBook(id, categoryName);
	}

}
