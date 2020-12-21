<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Delete a player</title>
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
