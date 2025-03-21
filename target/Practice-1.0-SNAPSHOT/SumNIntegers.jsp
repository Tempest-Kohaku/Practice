<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Sum of Square Numbers</title>
    </head>
    <body>
        <form method="get">
            Enter a Number: <input type="number" name="num" />
            <input type="submit" value="Find" />
        </form>
        <c:if test="${not empty param.num}">
            <c:set var="sum" value="0" />
            <c:forEach var="i" begin="1" end="${param.num}">
                <c:set var="sum" value="${sum + (i * i)}" />
            </c:forEach>
            <p>Sum of squares of ${param.num} integers is: ${sum}</p>
        </c:if>
    </body>
</html>