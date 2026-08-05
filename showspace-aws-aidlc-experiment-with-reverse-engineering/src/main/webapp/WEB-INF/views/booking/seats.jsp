<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Select Seats - Showspace</title>
</head>
<body>
    <h1>Select Seats for Showtime</h1>
    <a href="${pageContext.request.contextPath}/movies/${showtime.movieId}/showtimes">Back to Showtimes</a>
    <hr>
    
    <c:if test="${not empty param.error}">
        <div style="color: red; margin-bottom: 10px;">
            One or more selected seats are no longer available. Please choose again.
        </div>
    </c:if>

    <form action="${pageContext.request.contextPath}/bookings/checkout" method="POST">
        <input type="hidden" name="showtimeId" value="${showtime.id}">
        
        <div>
            <c:forEach var="seat" items="${seats}">
                <div style="margin-bottom: 5px;">
                    <c:choose>
                        <c:when test="${seat.status == 'AVAILABLE'}">
                            <input type="checkbox" name="seatIds" id="seat_${seat.id}" value="${seat.id}">
                            <label for="seat_${seat.id}">
                                ${seat.seatNumber} (${seat.seatType}) 
                                - <c:if test="${seat.seatType == 'VIP'}">+ $5.00</c:if>
                            </label>
                        </c:when>
                        <c:otherwise>
                            <input type="checkbox" disabled>
                            <label style="color: gray;">${seat.seatNumber} (BOOKED)</label>
                        </c:otherwise>
                    </c:choose>
                </div>
            </c:forEach>
            <c:if test="${empty seats}">
                <p>No seats configured for this showtime.</p>
            </c:if>
        </div>
        
        <br>
        <button type="submit" <c:if test="${empty seats}">disabled</c:if>>Confirm Booking</button>
    </form>
</body>
</html>