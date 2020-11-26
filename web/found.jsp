<%@ page import="domain.model.Speler" %><%--
  Created by IntelliJ IDEA.
  User: toond
  Date: 10/20/2020
  Time: 12:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gevonden</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
<header>
</header>
<main>
    <nav>
        <ul>
            <li><a href="ENindex.jsp">Home</a></li>
            <li><a href="Servlet?command=overzicht">Overview</a></li>
            <li><a href="add.jsp">Add</a></li>
            <li><a href="search.jsp">Search</a></li>
        </ul>
    </nav>
    <h1>Speler gevonden</h1>

    <div id="Hometext">
        <p>Here is some info about the player you searched</p>
        <p>Name: ${speler.naam}</p>
        <p>Age: ${speler.leeftijd}</p>
        <p>Position: ${speler.positie}</p>
        <p>Games played: ${speler.wedstrijden}</p>
    </div>
</main>
</body>
</html>
