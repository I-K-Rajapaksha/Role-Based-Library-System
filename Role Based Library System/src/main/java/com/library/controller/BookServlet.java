package com.library.controller;

import com.library.dao.BookDAO;
import com.library.model.Book;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/addBook")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setStatus("Available");

        BookDAO dao = new BookDAO();
        dao.addBook(book);

        resp.sendRedirect("dashboard.jsp");
    }
}
