package domain.db;

import domain.model.Speler;

import java.util.ArrayList;

public class SpelerDB {

    ArrayList<Speler> spelers;


    public SpelerDB(){
        Speler robbeSarens = new Speler("Robbe Sarens", 20, "Middle blocker", 13);
        Speler gillesVanDenHeuvel = new Speler("Gilles Van Den Heuvel", 19, "Ace", 11);
        Speler alessioVortice = new Speler("Alessio Vortice", 20, "Wing spiker", 6);
        Speler jarneArnouts = new Speler("Jarne Arnouts", 18, "Libero", 18);

        spelers = new ArrayList<>();
        voegToe(robbeSarens);
        voegToe(gillesVanDenHeuvel);
        voegToe(alessioVortice);
        voegToe(jarneArnouts);
    }

    public void voegToe(Speler speler){
        if (speler==null)
            throw new IllegalArgumentException("Geen geldige student");
        spelers.add(speler);
    }

    public Speler vindSpeler(String naam){
        for(Speler speler: spelers){
            if(speler.getNaam().equals(naam)){return speler;}

        }
        return null;
    }

    public ArrayList<Speler> getSpelers(){
        return spelers;
    }

    public void verwijderSpeler(String naam){
        for (Speler speler: spelers){
            if (speler.getNaam().equals(naam)){
                spelers.remove(speler);
                break;
            }
        }
    }
}
