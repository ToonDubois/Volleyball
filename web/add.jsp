<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <a href="Servlet?command=switchNL&page=add" id="languageChange">NL</a>
    <nav>
        <ul>
            <li><a href="ENindex.jsp">Home</a></li>
            <li><a href="Servlet?command=overzicht">Overview</a></li>
            <li><a href="add.jsp" id="onPage">Add</a></li>
            <li><a href="search.jsp">Search</a></li>
        </ul>
    </nav>
    <h1>Add a player here.</h1>

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
            <label for="speler">Player: </label><br>
            <input type="text" id="speler" name="speler" value="${naamPrevious}"><br>
            <label for ="leeftijd">Age: </label><br>
            <input type="number" id="leeftijd" name="leeftijd" value="${leeftijdPrevious}"><br>
            <label for="positie">Position: </label><br>
            <input type="text" id="positie" name="positie" value="${positiePrevious}"><br>
            <label for="wedstrijdenGespeeld">Games played: </label><br>
            <input type="number" id="wedstrijdenGespeeld" name="wedstrijdenGespeeld" value="${wedstrijdenPrevious}"><br>
            <input type="submit" value="Submit">
        </form>
    </article>

</main>
</body>
</html>