<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${movie.title} - Details</title>
</head>
<body>
    <h1>${movie.title}</h1>
    <a href="${pageContext.request.contextPath}/movies/now-showing">Back to Now Showing</a>
    <hr>
    
    <div>
        <c:if test="${not empty movie.posterImageUrl}">
            <img src="${movie.posterImageUrl}" alt="Poster for ${movie.title}" width="200" />
        </c:if>
        
        <p><strong>Status:</strong> ${movie.status}</p>
        <p><strong>Release Date:</strong> ${movie.releaseDate}</p>
        <p><strong>Genre:</strong> ${movie.metadata.genre}</p>
        <p><strong>Duration:</strong> ${movie.metadata.durationInMinutes} minutes</p>
        <p><strong>Country:</strong> ${movie.metadata.countryOfOrigin}</p>
        <p><strong>Age Rating:</strong> ${movie.metadata.ageRating}</p>
        
        <h3>Synopsis</h3>
        <p>${movie.synopsis}</p>
        
        <h3>Available Formats</h3>
        <ul>
            <c:forEach var="format" items="${movie.formats}">
                <li>${format.formatType} - ${format.languageType}</li>
            </c:forEach>
            <c:if test="${empty movie.formats}">
                <li>No formats listed yet.</li>
            </c:if>
        </ul>
        
        <c:if test="${not empty movie.trailerUrl}">
            <p><a href="${movie.trailerUrl}" target="_blank">Watch Trailer</a></p>
        </c:if>
    </div>
</body>
</html>