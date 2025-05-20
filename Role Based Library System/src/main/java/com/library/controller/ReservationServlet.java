package com.library.controller;

import com.library.dao.ReservationDAO;
import com.library.dao.BookDAO;
import com.library.model.Reservation;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/reserveBook")
public class ReservationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        String studentName = req.getParameter("studentName");

        Reservation res = new Reservation();
        res.setBookId(bookId);
        res.setStudentName(studentName);
        res.setReservationDate(LocalDate.now().toString());

        ReservationDAO dao = new ReservationDAO();
        dao.reserveBook(res);

        // Update book status to "Reserved"
        BookDAO bookDAO = new BookDAO();
        bookDAO.updateBookStatus(bookId, "Reserved");

        resp.sendRedirect("dashboard.jsp");
    }
}
