<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
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
            <li><a href="index.jsp">Home</a></li>
            <li><a href="Servlet?command=overzicht">Overzicht</a></li>
            <li><a href="voegtoe.jsp">Voeg Toe</a></li>
            <li><a href="zoek.jsp">Zoek</a></li>
        </ul>
    </nav>
    <h1>Verwijder deze speler</h1>
    <article id="tablediv">
        <p>Ben je zeker dat je de speler ${naam} wil verwijderen?</p><br>
        <form action="Servlet?command=verwijderVolledig" method="POST">
            <input type="hidden" name="naam" value="${naam}">
            <input type="submit" name="submit" value="Zeker">
            <input type="submit" name="submit" value="Toch niet">
        </form>
    </article>
</main>

</body>
</html>
