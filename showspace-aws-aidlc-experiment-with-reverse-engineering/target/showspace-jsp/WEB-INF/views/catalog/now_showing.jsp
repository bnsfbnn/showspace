<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Now Showing - Showspace</title>
</head>
<body>
    <h1>Movies Now Showing</h1>
    <a href="${pageContext.request.contextPath}/">Back to Home</a> | 
    <a href="${pageContext.request.contextPath}/movies/coming-soon">View Coming Soon</a>
    <hr>
    <div>
        <c:forEach var="movie" items="${movies}">
            <div style="border: 1px solid #ccc; padding: 10px; margin-bottom: 10px;">
                <h2><a href="${pageContext.request.contextPath}/movies/${movie.id}">${movie.title}</a></h2>
                <p><strong>Genre:</strong> ${movie.metadata.genre}</p>
                <p><strong>Duration:</strong> ${movie.metadata.durationInMinutes} mins</p>
                <p><strong>Age Rating:</strong> ${movie.metadata.ageRating}</p>
            </div>
        </c:forEach>
        <c:if test="${empty movies}">
            <p>No movies are currently showing.</p>
        </c:if>
    </div>
</body>
</html>