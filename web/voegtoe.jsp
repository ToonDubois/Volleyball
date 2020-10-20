<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>VoegToe</title>
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
            <li><a href="voegtoe.jsp" id="onPage">Voeg Toe</a></li>
            <li><a href="zoek.jsp">Zoek</a></li>
        </ul>
    </nav>
<h1>Voeg hier een speler toe</h1>
    <article id="tablediv">
        <form method="post" action="Servlet?command=voegtoe" novalidate>
            <label for="speler">Speler: </label><br>
            <input type="text" id="speler" name="speler" required><br>
            <label for ="leeftijd">Leeftijd: </label><br>
            <input type="number" id="leeftijd" name="leeftijd" required><br>
            <label for="positie">Positie: </label><br>
            <input type="text" id="positie" name="positie" required><br>
            <label for="wedstrijdenGespeeld">Wedstrijden Gespeeld: </label><br>
            <input type="number" id="wedstrijdenGespeeld" name="wedstrijdenGespeeld" required><br>
            <input type="submit" value="Submit">
        </form>
    </article>

</main>
</body>
</html>