package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper {

	public static Author map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String firstName = result.getString("first_name");
		String lastName = result.getString("last_name");
		String email = result.getString("email");
		String address = result.getString("address");
		int birthdayDate = result.getInt("birthday_date");
		
		return new Author(id, firstName, lastName, email, address, birthdayDate);
	}

}
