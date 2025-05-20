<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.library.dao.ReservationDAO, java.util.List, com.library.model.Reservation" %>
<%
    ReservationDAO dao = new ReservationDAO();
    List<Reservation> reservationList = dao.getAllReservations();
    request.setAttribute("reservationList", reservationList);
%>
<link rel="stylesheet" href="css/style.css" />
<div class="container">

<c:forEach var="r" items="${reservationList}">
    <p>${r.studentName} reserved Book ID: ${r.bookId} on ${r.reservationDate}</p>
</c:forEach>
</div>