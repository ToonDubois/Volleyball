<%--
  Created by IntelliJ IDEA.
  User: toond
  Date: 10/20/2020
  Time: 12:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zoek</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
<header>
</header>

<main>
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
    </article>
</main>
</body>
</html>
