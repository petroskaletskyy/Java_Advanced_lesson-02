package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	
	private static String READ_ALL = "select * from book";
	private static String CREATE = "insert into book(`book_name`, `book_description`, `price`, `isbn`) values (?,?,?,?)";
	private static String READ_BY_ID = "select * from book where id =?";
	private static String UPDATE_BY_ID = "update book set book_name=?, book_description = ?, price = ?, isbn = ? where id = ?";
	private static String DELETE_BY_ID = "delete from book where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public BookDAO(Connection connection) {
		this.connection = connection;
	}

	public void insert(Book book) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, book.getBookName());
		preparedStatement.setString(2, book.getBookDescription());
		preparedStatement.setDouble(3, book.getPrice());
		preparedStatement.setString(4, book.getIsbn());
		preparedStatement.executeUpdate();
	}

	public Book read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return BookMapper.map(result);
	}

	public void update(Book book) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, book.getBookName());
		preparedStatement.setString(2, book.getBookDescription());
		preparedStatement.setDouble(3, book.getPrice());
		preparedStatement.setString(4, book.getIsbn());
		preparedStatement.setInt(5, book.getId());
		preparedStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

	public List<Book> readAll() throws SQLException {
		List<Book> listOfBook = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			listOfBook.add(BookMapper.map(result));
		}
		return listOfBook;
	}

}
