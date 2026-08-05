<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>${message}</h1>
    
    <h2>Catalog</h2>
    <ul>
        <li><a href="${pageContext.request.contextPath}/movies/now-showing">Now Showing</a></li>
        <li><a href="${pageContext.request.contextPath}/movies/coming-soon">Coming Soon</a></li>
    </ul>
</body>
</html>
