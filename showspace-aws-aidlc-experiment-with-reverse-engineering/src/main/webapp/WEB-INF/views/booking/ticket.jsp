<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Tickets - Showspace</title>
</head>
<body>
    <h1>Booking Confirmed!</h1>
    <p>Your Booking ID: ${bookingId}</p>
    <a href="${pageContext.request.contextPath}/">Back to Home</a>
    <hr>
    
    <h2>Your Tickets</h2>
    <div>
        <c:forEach var="ticket" items="${tickets}">
            <div style="border: 2px dashed #000; padding: 15px; margin-bottom: 15px; display: inline-block;">
                <h3>Ticket Code: ${ticket.ticketCode}</h3>
                <p>Booking ID: ${ticket.bookingId}</p>
                <p>Seat ID: ${ticket.seatId}</p>
                <p><em>(Show this code at the cinema counter)</em></p>
            </div>
            <br>
        </c:forEach>
    </div>
</body>
</html>