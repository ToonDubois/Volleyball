<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <title>Voeg Toe</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
<header>
</header>
<main>
    <a href="Servlet?command=switchEN&page=voegtoe" id="languageChange">EN</a>
    <nav>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="Servlet?command=overzicht">Overzicht</a></li>
            <li><a href="voegtoe.jsp" id="onPage">Voeg Toe</a></li>
            <li><a href="zoek.jsp">Zoek</a></li>
        </ul>
    </nav>
<h1>Voeg hier een speler toe</h1>

    <c:if test="${not empty errors}">
        <div class="alert">
            <ul>
                <c:forEach items="${errors}" var="error">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>

    <article id="tablediv">
        <form method="post" action="Servlet?command=voegtoe" novalidate>
            <label for="speler">Speler: </label><br>
            <input type="text" id="speler" name="speler" value="${naamPrevious}"><br>
            <label for ="leeftijd">Leeftijd: </label><br>
            <input type="number" id="leeftijd" name="leeftijd" value="${leeftijdPrevious}"><br>
            <label for="positie">Positie: </label><br>
            <input type="text" id="positie" name="positie" value="${positiePrevious}"><br>
            <label for="wedstrijdenGespeeld">Wedstrijden Gespeeld: </label><br>
            <input type="number" id="wedstrijdenGespeeld" name="wedstrijdenGespeeld" value="${wedstrijdenPrevious}"><br>
            <input type="submit" value="Submit">
        </form>
    </article>

</main>
</body>
</html>