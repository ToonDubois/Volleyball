package ui.controller;

import domain.db.SpelerDB;
import domain.model.Speler;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


@WebServlet("/Servlet")
public class Servlet extends javax.servlet.http.HttpServlet {

private SpelerDB spelerdb = new SpelerDB();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String destination;

        String naam = request.getParameter("speler");
        String leeftijd = request.getParameter("leeftijd");
        String positie = request.getParameter("positie");
        String wedstrijden = request.getParameter("wedstrijdenGespeeld");
        if(naam == null || positie == null || naam.trim().isEmpty() || leeftijd.isEmpty() ||positie.trim().isEmpty() ||wedstrijden.isEmpty() || Integer.parseInt(wedstrijden)<=0 || Integer.parseInt(leeftijd)<=0){
            destination = "voegToe.jsp";
        }
        else {spelerdb.voegToe(new Speler(naam,Integer.parseInt(leeftijd),positie,Integer.parseInt(wedstrijden)));
            request.setAttribute("spelerdb", spelerdb.getSpelers());
            destination = "overzicht.jsp";
        }
        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request,response);



    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String destination;

        destination = "overzicht.jsp";
        request.setAttribute("spelerdb",spelerdb.getSpelers());


        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request,response);
    }
}
