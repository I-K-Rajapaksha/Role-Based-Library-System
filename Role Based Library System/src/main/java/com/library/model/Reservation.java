package com.library.model;

public class Reservation {
    private int id;
    private int bookId;
    private String studentName;
    private String reservationDate;

    // Getters
    public int getId() { return id; }
    public int getBookId() { return bookId; }
    public String getStudentName() { return studentName; }
    public String getReservationDate() { return reservationDate; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setBookId(int bookId) { this.bookId = bookId; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public void setReservationDate(String reservationDate) { this.reservationDate = reservationDate; }
}
