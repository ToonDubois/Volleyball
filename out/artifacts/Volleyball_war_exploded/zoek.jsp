<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <title>Zoek</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
<header>
</header>

<main>
    <a href="Servlet?command=switchEN&page=zoek" id="languageChange">EN</a>
    <nav>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="Servlet?command=overzicht">Overzicht</a></li>
            <li><a href="voegtoe.jsp">Voeg Toe</a></li>
            <li><a href="zoek.jsp" id="onPage">Zoek</a></li>
        </ul>
    </nav>
<h1>Zoek een speler</h1>
    <article id="tablediv">
<form action="Servlet" method="GET" novalidate>
    <input type="hidden" name="command" value="zoek">
    <label for="naam">Naam: </label>
    <input type="text" id="naam" name="naam" required><br>
    <input type="submit">
</form>

        <c:if test="${not empty spelers}">
            <br>
            <p>Recent gezocht:</p>
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
