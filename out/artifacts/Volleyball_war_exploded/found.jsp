<%@ page import="domain.model.Speler" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Found</title>
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
