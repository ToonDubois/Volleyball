<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="domain.model.Speler" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Overview</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
<header>
</header>
<main>
    <a href="Servlet?command=switchNL&page=overview" id="languageChange">NL</a>
    <nav>
        <ul>
            <li><a href="ENindex.jsp">Home</a></li>
            <li><a href="Servlet?command=overzicht" id="onPage">Overview</a></li>
            <li><a href="add.jsp">Add</a></li>
            <li><a href="search.jsp">Search</a></li>
        </ul>
    </nav>
    <h1>Overview of players</h1>
    <div id="tablediv">
        <c:if test="${not empty spelerdb}">

            <table style="width:100%">
                <tr>
                    <th><strong>Player</strong></th>
                    <th><strong>Age</strong></th>
                    <th><strong>Position</strong></th>
                    <th><strong>Games played</strong></th>
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
                        <td><a href="Servlet?command=verwijder&naam=${speler.naam}">Delete</a></td>
                        <td><a href="Servlet?command=update&naam=${speler.naam}">Update</a></td>
                    </tr>
                </c:forEach>

            </table>
        </c:if>
    </div>

</main>
</body>
</html>