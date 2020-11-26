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

<main>
    <nav>
        <ul>
            <li><a href="ENindex.jsp">Home</a></li>
            <li><a href="Servlet?command=overzicht">Overview</a></li>
            <li><a href="add.jsp">Add</a></li>
            <li><a href="search.jsp">Search</a></li>
        </ul>
    </nav>
    <h1>Delete this player</h1>
    <article id="tablediv">
        <p>Are you sure you want to delete player ${naam}</p><br>
        <form action="Servlet?command=verwijderVolledig" method="POST">
            <input type="hidden" name="naam" value="${naam}">
            <input type="submit" name="submit" value="Yes">
            <input type="submit" name="submit" value="No">
        </form>
    </article>
</main>

</body>
</html>
