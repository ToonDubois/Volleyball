<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="domain.model.Speler" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Overzicht</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
<header>
</header>
<main>
    <a href="Servlet?command=switchEN&page=overzicht" id="languageChange">EN</a>
    <nav>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="Servlet?command=overzicht" id="onPage">Overzicht</a></li>
            <li><a href="voegtoe.jsp">Voeg Toe</a></li>
            <li><a href="zoek.jsp">Zoek</a></li>
        </ul>
    </nav>
    <h1>Overzicht van spelers</h1>
    <div id="tablediv">
        <c:if test="${not empty spelerdb}">

<table style="width:100%">
    <tr>
        <th><strong>Speler</strong></th>
        <th><strong>Leeftijd</strong></th>
        <th><strong>Positie</strong></th>
        <th><strong>Wedstrijden gespeeld</strong></th>
    </tr>


    <c:forEach var="speler" items="${spelerdb}">
    <tr>
        <td>${speler.naam}
        </td>
        <td>${speler.leeftijd}
        </td>
        <td>${speler.positie}
        </td>
        <td>${speler.wedstrijden}
        </td>
        <td><a href="Servlet?command=verwijder&naam=${speler.naam}">Verwijder</a></td>
        <td><a href="Servlet?command=update&naam=${speler.naam}">Update</a></td>
    </tr>
    </c:forEach>
    
</table>
        </c:if>
    </div>

</main>
</body>
</html>