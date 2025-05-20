<link rel="stylesheet" href="css/style.css" />
<%@ page import="com.library.model.Book, com.library.dao.BookDAO" %>
<%
    int bookId = Integer.parseInt(request.getParameter("bookId"));
    BookDAO dao = new BookDAO();
    Book book = dao.getBookById(bookId);
%>
<div class="container">
<h2>Reserve Book: <%= book.getTitle() %></h2>
<form action="reserveBook" method="post">
    <input type="hidden" name="bookId" value="<%= book.getId() %>"/>
    Student Name: <input type="text" name="studentName" required/><br/>
    <input type="submit" value="Confirm Reservation"/>
</form>
</div>