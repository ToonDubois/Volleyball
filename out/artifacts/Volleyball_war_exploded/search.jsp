<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Search</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
<header>
</header>

<main>
    <a href="Servlet?command=switchNL&page=search" id="languageChange">NL</a>
    <nav>
        <ul>
            <li><a href="ENindex.jsp">Home</a></li>
            <li><a href="Servlet?command=overzicht">Overview</a></li>
            <li><a href="add.jsp">Add</a></li>
            <li><a href="search.jsp" id="onPage">Search</a></li>
        </ul>
    </nav>
    <h1>Search for a player</h1>
    <article id="tablediv">
        <form action="Servlet" method="GET" novalidate>
            <input type="hidden" name="command" value="zoek">
            <label for="naam">Name: </label>
            <input type="text" id="naam" name="naam" required><br>
            <input type="submit">
        </form>

    <c:if test="${not empty spelers}">
        <br>
        <p>Recent searches:</p>
        <ol>
            <c:forEach var ="spelers" items="${spelers}">

                <li><p>${spelers.naam}</p></li>
            </c:forEach>
        </ol>
    </c:if>
    </article>
</main>
</body>
</html>
