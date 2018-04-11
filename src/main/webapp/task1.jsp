<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<body>
<form action="task1" method="get">
    Filter:<br>
    <input type="text" name="filter"><br>
    <input type="submit" value="Filter">
</form>
<h1>Result:</h1>
<table>
    <thead>
    <tr>
        <th>Product</th>
        <th>Company</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="model" items="${result}">
        <tr>
            <td>${model.product}</td>
            <td>${model.company}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
