package ui.controller;

import domain.db.SpelerDB;
import domain.model.Speler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;


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
        String taal;
        if (request.getParameter("command")!=null){command = request.getParameter("command");}
        else{command = "";}

        switch(command){

            case "overzicht":
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

            case "update":
                destination = update(request,response);
                break;

            case "updatebevestiging":
                destination = updatebevestiging(request,response);
                break;

            case "switchNL":
                destination = switchL(request,response,"NL");
                break;

            case "switchEN":
                destination = switchL(request,response, "EN");
                break;

            default:
                destination = overzicht(request,response);
        }

        request.getRequestDispatcher(destination).forward(request, response);


    }


    private String overzicht(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("spelerdb", spelerdb.getSpelerdb());
        Cookie cookie = getCookieWithKey(request, "language");
        if (cookie != null && cookie.getValue().equals("NL")){
            return "overzicht.jsp";}
        else return "overview.jsp";
    }


    private String zoek(HttpServletRequest request, HttpServletResponse response){
        String naam = request.getParameter("naam");
        if(spelerdb.vindSpeler(naam)!=null){
            request.setAttribute("speler",spelerdb.vindSpeler(naam));
            Cookie cookie = getCookieWithKey(request, "language");
            if (cookie != null && cookie.getValue().equals("NL")){
            return "gevonden.jsp";}
            else{return "found.jsp";}
        }
        Cookie cookie = getCookieWithKey(request, "language");
        if (cookie != null && cookie.getValue().equals("NL")){
        return "nietgevonden.jsp";}
        else{return "notfound.jsp";}
    }


    private String voegtoe(HttpServletRequest request, HttpServletResponse response){
        ArrayList<String> errors = new ArrayList<>();

        Speler speler = new Speler();
        setNaam(speler, request, errors);
        setLeeftijd(speler, request, errors);
        setPositie(speler, request, errors);
        setWedstrijden(speler, request, errors);

        if(errors.size() == 0){
            try{
                spelerdb.voegToe(speler);
                return overzicht(request,response);
            }
            catch(IllegalArgumentException exc){
                errors.add(exc.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return "voegtoe.jsp";
    }



    private String verwijder(HttpServletRequest request, HttpServletResponse response){
        String naam = request.getParameter("naam");

        request.setAttribute("naam", naam);
        Cookie cookie = getCookieWithKey(request, "language");
        if (cookie != null && cookie.getValue().equals("NL")){
        return "verwijderbevestiging.jsp";}
        else {return "deletecomplete.jsp";}
    }



    private String verwijdervolledig(HttpServletRequest request, HttpServletResponse response){
        String naam = request.getParameter("naam");
        String submit = request.getParameter("submit");

        if(submit.equals("Zeker")){
            spelerdb.verwijderSpeler(naam);
            request.setAttribute("spelerdb",spelerdb.getSpelerdb());
            return "overzicht.jsp";
        }
        if (submit.equals("Yes")){
            spelerdb.verwijderSpeler(naam);
            request.setAttribute("spelerdb",spelerdb.getSpelerdb());
            return "overview.jsp";
        }
        if(submit.equals("No")){
            request.setAttribute("spelerdb",spelerdb.getSpelerdb());
            return "overview.jsp";
        }
        else{
            request.setAttribute("spelerdb",spelerdb.getSpelerdb());
            return "overzicht.jsp";
        }
    }



    private String update(HttpServletRequest request, HttpServletResponse response){
        String naam = request.getParameter("naam");

        request.setAttribute("speler", spelerdb.vindSpeler(naam));
        Cookie cookie = getCookieWithKey(request, "language");
        if (cookie != null && cookie.getValue().equals("NL")){
        return "update.jsp";}
        else{return "ENupdate.jsp";}
    }



    private String updatebevestiging(HttpServletRequest request, HttpServletResponse response){
        ArrayList<String> errors = new ArrayList<>();

        Speler speler = spelerdb.vindSpeler(request.getParameter("naam"));
        setNaam(speler, request, errors);
        setLeeftijd(speler, request, errors);
        setPositie(speler, request, errors);
        setWedstrijden(speler, request, errors);

        if(errors.size() == 0){
            try{
                speler.setNaam(request.getParameter("speler"));
                speler.setLeeftijd(Integer.parseInt(request.getParameter("leeftijd")));
                speler.setPositie(request.getParameter("positie"));
                speler.setWedstrijden(Integer.parseInt(request.getParameter("wedstrijdenGespeeld")));
                return overzicht(request,response);
            }
            catch(IllegalArgumentException exc){
                errors.add(exc.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        Cookie cookie = getCookieWithKey(request, "language");
        if (cookie != null && cookie.getValue().equals("NL")){
        return "update.jsp";}
        else{return "ENupdate.jsp";}
    }


    private void setNaam(Speler speler, HttpServletRequest request, ArrayList<String> errors){
        String naam = request.getParameter("speler");
        try{
            speler.setNaam(naam);
            request.setAttribute("naamPrevious", naam);
        }
        catch(IllegalArgumentException exc){
            errors.add(exc.getMessage());
        }
    }

    private void setPositie(Speler speler, HttpServletRequest request, ArrayList<String> errors){
        String positie = request.getParameter("positie");
        try{
            speler.setPositie(positie);
            request.setAttribute("positiePrevious", positie);
        }
        catch(IllegalArgumentException exc){
            errors.add(exc.getMessage());
        }
    }

    private void setLeeftijd(Speler speler, HttpServletRequest request, ArrayList<String> errors){
        String leeftijd = request.getParameter("leeftijd");
        try{
            speler.setLeeftijd(Integer.parseInt(leeftijd));
            request.setAttribute("leeftijdPrevious", leeftijd);
        }
        catch(NumberFormatException exc){
            errors.add("Vul een nummer in voor leeftijd");
        }
        catch(IllegalArgumentException exc){
            errors.add(exc.getMessage());
        }

    }

    private void setWedstrijden(Speler speler, HttpServletRequest request, ArrayList<String> errors){
        String wedstrijden = request.getParameter("wedstrijdenGespeeld");
        try{
            speler.setWedstrijden(Integer.parseInt(wedstrijden));
            request.setAttribute("wedstrijdenPrevious", wedstrijden);
        }
        catch(NumberFormatException exc){
            errors.add("Vul een nummer in voor wedstrijden");
        }
        catch(IllegalArgumentException exc){
            errors.add(exc.getMessage());
        }

    }

    private Cookie getCookieWithKey(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null)
            return null;
        for (Cookie cookie : cookies
        ) {
            if (cookie.getName().equals(key))
                return cookie;
        }
        return null;
    }

    private String switchL(HttpServletRequest request, HttpServletResponse response, String language) {
        String destination = "overzicht.jsp";

        Cookie c = new Cookie("language", language);
        response.addCookie(c);
        if(request.getParameter("page")!=null){
        if (language == null || language.equals("NL")) {
            request.setAttribute("requestCookie", "NL");
            switch (request.getParameter("page")) {
                case "overview":
                    request.setAttribute("spelerdb", spelerdb.getSpelerdb());
                    destination = "overzicht.jsp";
                    break;

                case "add":
                    destination = "voegtoe.jsp";
                    break;

                case "search":
                    destination = "zoek.jsp";
                    break;

                case "ENindex":
                    destination = "index.jsp";
                    break;
                default: destination="index.jsp";
            }
        } else {
            request.setAttribute("requestCookie", "EN");
            switch (request.getParameter("page")) {
                case "overzicht":
                    request.setAttribute("spelerdb", spelerdb.getSpelerdb());
                    destination = "overview.jsp";
                    break;

                case "voegtoe":
                    destination = "add.jsp";
                    break;

                case "zoek":
                    destination = "search.jsp";
                    break;

                case "index":
                    destination = "ENindex.jsp";
                    break;
                default: destination="ENindex.jsp";
            }
        }}
        return destination;
    }

    }
