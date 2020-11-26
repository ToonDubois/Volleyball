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
    </article>
</main>
</body>
</html>
