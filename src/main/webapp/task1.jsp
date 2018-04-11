<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<body>
<h1>Result:</h1>
<table>
    <thead>
    <tr>
        <th>Company</th>
        <th>Product</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="model" items="${result}">
        <tr>
            <td>${model.company}</td>
            <td>${model.product}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
