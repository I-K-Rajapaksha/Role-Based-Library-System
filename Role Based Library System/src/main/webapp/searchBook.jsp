<link rel="stylesheet" href="css/style.css" />
<%@ page import="com.library.dao.BookDAO, java.util.List, com.library.model.Book" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    BookDAO dao = new BookDAO();
    List<Book> bookList = dao.getAllAvailableBooks();
    request.setAttribute("bookList", bookList);
%>
<div class="container">

<h2>Available Books</h2>

<table border="1">
    <tr><th>ID</th><th>Title</th><th>Author</th><th>Action</th></tr>
    <c:forEach var="b" items="${bookList}">
        <tr>
            <td>${b.id}</td>
            <td>${b.title}</td>
            <td>${b.author}</td>
            <td><a href="reserveForm.jsp?bookId=${b.id}">Reserve</a></td>
        </tr>
    </c:forEach>
</table>

<a href="dashboard.jsp">Back to Dashboard</a>
</div>