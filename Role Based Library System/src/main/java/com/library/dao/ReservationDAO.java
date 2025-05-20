package com.library.dao;

import com.library.model.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/librarydb";
    private final String dbUser = "root";
    private final String dbPassword = "";

    public List<Reservation> getAllReservations() {
        List<Reservation> list = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            String sql = "SELECT * FROM reservations";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Reservation r = new Reservation();
                r.setId(rs.getInt("id"));
                r.setBookId(rs.getInt("book_id"));
                r.setStudentName(rs.getString("student_name"));
                r.setReservationDate(rs.getString("reservation_date"));
                list.add(r);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void reserveBook(Reservation res) {
        try {
            Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            String sql = "INSERT INTO reservations (book_id, student_name, reservation_date) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, res.getBookId());
            stmt.setString(2, res.getStudentName());
            stmt.setString(3, res.getReservationDate());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
