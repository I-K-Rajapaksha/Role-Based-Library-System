<link rel="stylesheet" href="css/style.css" />
<%@ page import="com.library.model.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
    }
%>
<div class="container">
<h2>Welcome, <%= user.getUsername() %> [<%= user.getRole() %>]</h2>

<% if ("Student".equals(user.getRole())) { %>
<a href="searchBook.jsp">Search & Reserve Books</a>
<% } else if ("Admin".equals(user.getRole())) { %>
<a href="addBook.jsp">Add Books</a> |
<a href="viewReservations.jsp">View Reservations</a>
</div>
<% } %>

<a href="logout">Logout</a>
