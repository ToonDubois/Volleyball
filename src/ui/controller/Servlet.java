package ui.controller;

import domain.db.SpelerDB;
import domain.model.Speler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/Servlet")
public class Servlet extends javax.servlet.http.HttpServlet {

private SpelerDB spelerdb = new SpelerDB();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request,response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String destination;
        String command;
        if (request.getParameter("command")!=null){command = request.getParameter("command");}
        else{command = "";}


        switch(command){

            case "overview":
                destination = overzicht(request,response);
                break;

            case "zoek":
                destination = zoek(request,response);
                break;

            case "voegtoe":
                destination = voegtoe(request,response);
                break;

            case "verwijder":
                destination = verwijder(request, response);
                break;

            case "verwijderVolledig":
                destination = verwijdervolledig(request,response);
                break;

            default:
                destination = overzicht(request,response);
        }

        request.getRequestDispatcher(destination).forward(request, response);


    }


    private String overzicht(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("spelerdb", spelerdb.getSpelers());
        return "overzicht.jsp";
    }

    private String zoek(HttpServletRequest request, HttpServletResponse response){
        String naam = request.getParameter("naam");
        if(spelerdb.vindSpeler(naam)!=null){
            request.setAttribute("speler",spelerdb.vindSpeler(naam));
            return "gevonden.jsp";
        }
        return "nietgevonden.jsp";
    }

    private String voegtoe(HttpServletRequest request, HttpServletResponse response){
        String naam = request.getParameter("speler");
        String leeftijd = request.getParameter("leeftijd");
        String positie = request.getParameter("positie");
        String wedstrijden = request.getParameter("wedstrijdenGespeeld");
        if(naam == null || positie == null || naam.trim().isEmpty() || leeftijd.isEmpty() ||positie.trim().isEmpty() ||wedstrijden.isEmpty() || Integer.parseInt(wedstrijden)<=0 || Integer.parseInt(leeftijd)<=0){
            return "voegtoe.jsp";
        }
        else {
            spelerdb.voegToe(new Speler(naam,Integer.parseInt(leeftijd),positie,Integer.parseInt(wedstrijden)));
            request.setAttribute("spelerdb", spelerdb.getSpelers());
            return "overzicht.jsp";
        }
    }

    private String verwijder(HttpServletRequest request, HttpServletResponse response){
        String naam = request.getParameter("naam");

        request.setAttribute("naam", naam);
        return "verwijderbevestiging.jsp";
    }

    private String verwijdervolledig(HttpServletRequest request, HttpServletResponse response){
        String naam = request.getParameter("naam");
        String submit = request.getParameter("submit");

        if(submit.equals("Zeker")){
            spelerdb.verwijderSpeler(naam);
            request.setAttribute("spelerdb",spelerdb.getSpelers());
            return "overzicht.jsp";
        }
        else{
            request.setAttribute("spelerdb",spelerdb.getSpelers());
            return "overzicht.jsp";
        }
    }
    }
