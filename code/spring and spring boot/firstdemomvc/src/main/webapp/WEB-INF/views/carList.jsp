<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Car List</title>
</head>
<body>
    <h2>Car List</h2>
    <c:forEach var="car" items="${carList}">
    <p>${car}</p>
</c:forEach>

</body>
</html>
