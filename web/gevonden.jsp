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
    <a href="Servlet?command=switchEN&page=gevonden">EN</a>
    <nav>
        <ul>
            <li><a href="index.jsp" id="onPage">Home</a></li>
            <li><a href="Servlet?command=overzicht">Overzicht</a></li>
            <li><a href="voegtoe.jsp">Voeg Toe</a></li>
            <li><a href="zoek.jsp">Zoek</a></li>
        </ul>
    </nav>
<h1>Speler gevonden</h1>

    <div id="Hometext">
    <p>Hier is wat info over de speler die u hebt opgezocht!</p>
    <p>Naam: ${speler.naam}</p>
    <p>Leeftijd: ${speler.leeftijd}</p>
    <p>Positie: ${speler.positie}</p>
    <p>Wedstrijden gespeeld: ${speler.wedstrijden}</p>
    </div>
</main>
</body>
</html>
