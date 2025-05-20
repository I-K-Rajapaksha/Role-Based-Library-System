package com.library.dao;

import com.library.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/librarydb";
    private final String dbUser = "root";
    private final String dbPassword = "";

    public void addBook(Book book) {
        try {
            Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            String sql = "INSERT INTO books (title, author, status) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getStatus());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllAvailableBooks() {
        List<Book> books = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            String sql = "SELECT * FROM books WHERE status = 'Available'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Book b = new Book();
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("author"));
                b.setStatus(rs.getString("status"));
                books.add(b);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    public Book getBookById(int bookId) {
        Book book = null;
        try {
            Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            String sql = "SELECT * FROM books WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, bookId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setStatus(rs.getString("status"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    public void updateBookStatus(int bookId, String status) {
        try {
            Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            String sql = "UPDATE books SET status=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, status);
            stmt.setInt(2, bookId);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
