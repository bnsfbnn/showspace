<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Showtimes - Showspace</title>
</head>
<body>
    <h1>Select a Showtime</h1>
    <a href="${pageContext.request.contextPath}/movies/${movieId}">Back to Movie Details</a>
    <hr>
    
    <div>
        <c:forEach var="showtime" items="${showtimes}">
            <div style="border: 1px solid #ccc; padding: 10px; margin-bottom: 10px;">
                <h3>${showtime.formatType} - ${showtime.audioLanguage}</h3>
                <p><strong>Time:</strong> ${showtime.startTime}</p>
                <p><strong>Base Price:</strong> $${showtime.basePrice}</p>
                <a href="${pageContext.request.contextPath}/showtimes/${showtime.id}/seats">
                    <button>Select Seats</button>
                </a>
            </div>
        </c:forEach>
        <c:if test="${empty showtimes}">
            <p>No showtimes available for this movie.</p>
        </c:if>
    </div>
</body>
</html>