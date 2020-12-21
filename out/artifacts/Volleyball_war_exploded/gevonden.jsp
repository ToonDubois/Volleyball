<%@ page import="domain.model.Speler" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
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
