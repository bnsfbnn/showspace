<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Coming Soon - Showspace</title>
</head>
<body>
    <h1>Movies Coming Soon</h1>
    <a href="${pageContext.request.contextPath}/">Back to Home</a> | 
    <a href="${pageContext.request.contextPath}/movies/now-showing">View Now Showing</a>
    <hr>
    <div>
        <c:forEach var="movie" items="${movies}">
            <div style="border: 1px solid #ccc; padding: 10px; margin-bottom: 10px;">
                <h2><a href="${pageContext.request.contextPath}/movies/${movie.id}">${movie.title}</a></h2>
                <p><strong>Release Date:</strong> ${movie.releaseDate}</p>
                <p><strong>Genre:</strong> ${movie.metadata.genre}</p>
            </div>
        </c:forEach>
        <c:if test="${empty movies}">
            <p>No upcoming movies at the moment.</p>
        </c:if>
    </div>
</body>
</html>