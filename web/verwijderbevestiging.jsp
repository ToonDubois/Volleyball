<%--
  Created by IntelliJ IDEA.
  User: toond
  Date: 10/20/2020
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Verwijder een speler</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
<header>
</header>
<%
    String naam = (String)request.getAttribute("naam");
%>
<main>
    <nav>
        <ul>
            <li><a href="index.jsp" id="onPage">Home</a></li>
            <li><a href="Servlet?command=overzicht">Overzicht</a></li>
            <li><a href="voegtoe.jsp">Voeg Toe</a></li>
            <li><a href="zoek.jsp">Zoek</a></li>
        </ul>
    </nav>
    <h1>Verwijder deze speler</h1>
    <article id="tablediv">
        <p>Ben je zeker dat je de speler <%=naam%> wil verwijderen?</p><br>
        <form action="Servlet?command=verwijderVolledig" method="POST">
            <input type="hidden" name="naam" value="<%=naam%>">
            <input type="submit" name="submit" value="Zeker">
            <input type="submit" name="submit" value="Toch niet">
        </form>
    </article>
</main>

</body>
</html>
