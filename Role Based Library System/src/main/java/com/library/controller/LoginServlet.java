package com.library.controller;

import com.library.dao.UserDAO;
import com.library.model.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDAO dao = new UserDAO();
        User user = dao.validateUser(username, password);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("dashboard.jsp");
        } else {
            resp.sendRedirect("error.jsp");
        }
        System.out.println("User: " + user);
        if (user != null) {
            System.out.println("Login success: " + user.getUsername());
        }

    }

}

