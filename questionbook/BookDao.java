package com.hsbc.books;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

	Connection conn = null;

	public BookDao() {
		conn = DBConnection.getConnection();
	}

	public List<Book> display(String lang) {

		List<Book> books = new ArrayList<>();

		ResultSet rs = null;

		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from bookstore where category = '" + lang + "'";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				books.add(new Book(rs.getString(1),rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;

	}
} 