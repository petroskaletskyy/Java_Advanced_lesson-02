package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryBookDAO {
	
	private static String READ_ALL = "select * from category_book";
	private static String CREATE = "insert into category_book(`category_name`) values (?)";
	private static String READ_BY_ID = "select * from category_book where id =?";
	private static String UPDATE_BY_ID = "update category_book set category_name=? where id = ?";
	private static String DELETE_BY_ID = "delete from category_book where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public CategoryBookDAO(Connection connection) {
		this.connection = connection;
	}

	public void insert(CategoryBook categoryBook) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, categoryBook.getCategoryName());
		preparedStatement.executeUpdate();
	}

	public CategoryBook read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return CategoryBookMapper.map(result);
	}

	public void update(CategoryBook categoryBook) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, categoryBook.getCategoryName());
		preparedStatement.setInt(2, categoryBook.getId());
		preparedStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

	public List<CategoryBook> readAll() throws SQLException {
		List<CategoryBook> listOfCategoryBook = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			listOfCategoryBook.add(CategoryBookMapper.map(result));
		}
		return listOfCategoryBook;
	}

}
