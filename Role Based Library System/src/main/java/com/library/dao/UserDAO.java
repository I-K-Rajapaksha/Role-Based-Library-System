package com.library.dao;

import com.library.model.User;

import java.sql.*;

public class UserDAO {

    // Replace with your actual DB details
    private final String jdbcURL = "jdbc:mysql://localhost:3306/librarydb";
    private final String dbUser = "root";
    private final String dbPassword = "";

    public User validateUser(String username, String password) {
        User user = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open connection
            Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            // Prepare SQL statement
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            // Execute query
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));

                System.out.println("✅ User validated: " + user.getUsername());
            } else {
                System.out.println("❌ Invalid credentials for: " + username);
            }

            // Close connections
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
