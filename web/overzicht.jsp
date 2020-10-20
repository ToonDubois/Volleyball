<%@ page import="domain.model.Speler" %>
<%@ page import="java.util.ArrayList" %>
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
            <li><a href="index.jsp">Home</a></li>
            <li><a href="Servlet?command=overzicht" id="onPage">Overzicht</a></li>
            <li><a href="voegtoe.jsp">Voeg Toe</a></li>
            <li><a href="zoek.jsp">Zoek</a></li>
        </ul>
    </nav>
    <h1>Overzicht van spelers</h1>
    <div id="tablediv">
<table style="width:100%">
    <tr>
        <th><strong>Speler</strong></th>
        <th><strong>Leeftijd</strong></th>
        <th><strong>Positie</strong></th>
        <th><strong>Wedstrijden gespeeld</strong></th>
    </tr>
    <%
        ArrayList<Speler> spelers = (ArrayList<Speler>)request.getAttribute("spelerdb");
        if (spelers != null) {
    %>
    <%for (Speler speler: spelers) {%>
    <tr>
        <td><%=speler.getNaam()%>
        </td>
        <td><%=speler.getLeeftijd()%>
        </td>
        <td><%=speler.getPositie()%>
        </td>
        <td><%=speler.getWedstrijden()%>
        </td>
        <td><a href="Servlet?command=verwijder&naam=<%=speler.getNaam()%>">Verwijder</a></td>
    </tr>
    <%}}%>

</table>
    </div>
</main>
</body>
</html>