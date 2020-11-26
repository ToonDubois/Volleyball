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
    <nav>
        <ul>
            <li><a href="ENindex.jsp">Home</a></li>
            <li><a href="Servlet?command=overzicht" id="onPage">Overview</a></li>
            <li><a href="add.jsp">Add</a></li>
            <li><a href="search.jsp">Search</a></li>
        </ul>
    </nav>
    <h1>Update a player</h1>

    <article id="tablediv">
        <form method="post" action="Servlet?command=updatebevestiging" novalidate>
            <label for="speler">Speler: </label><br>
            <input type="text" id="speler" name="speler" value="${speler.naam}"><br>
            <label for ="leeftijd">Leeftijd: </label><br>
            <input type="number" id="leeftijd" name="leeftijd" value="${speler.leeftijd}"><br>
            <label for="positie">Positie: </label><br>
            <input type="text" id="positie" name="positie" value="${speler.positie}"><br>
            <label for="wedstrijdenGespeeld">Wedstrijden Gespeeld: </label><br>
            <input type="number" id="wedstrijdenGespeeld" name="wedstrijdenGespeeld" value="${speler.wedstrijden}"><br>
            <input type="submit" value="Submit">
            <input type="hidden" name="naam" value="${speler.naam}">
        </form>
    </article>
</main>

</body>
</html>
