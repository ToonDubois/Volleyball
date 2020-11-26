package domain.model;

public class Speler {

        private String naam, positie;
        private int leeftijd, wedstrijden;

        public Speler(String naam, int leeftijd, String positie, int wedstrijden) {
            if(!isValidString(naam) || !isValidString(positie)|| !isValidInt(leeftijd) || !isValidInt(wedstrijden)){throw new IllegalArgumentException("Een parameter is fout");}
            this.naam = naam;
            this.positie = positie;
            this.leeftijd = leeftijd;
            this.wedstrijden = wedstrijden;
        }

        public Speler(){}

    public String getNaam() {
        return naam;
    }

    public String getPositie() {
        return positie;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public int getWedstrijden() {
        return wedstrijden;
    }

    public static boolean isValidString(String input) {
            return (input != null) && !(input.trim().isEmpty());
        }

    public static boolean isValidInt(int i) {
            return i > 0;
        }

    public void setNaam(String naam) {
            if(naam == null || naam.isEmpty()){
                throw new IllegalArgumentException("Vul een speler in.");
            }
        this.naam = naam;
    }

    public void setPositie(String positie) {
        if(positie == null || positie.isEmpty()){
            throw new IllegalArgumentException("Vul een positie in.");
        }
        this.positie = positie;
    }

    public void setLeeftijd(int leeftijd) {
            if(leeftijd <=0){
                throw new IllegalArgumentException("Vul een leeftijd in");
            }
        this.leeftijd = leeftijd;
    }

    public void setWedstrijden(int wedstrijden) {
            if(wedstrijden<=0){
                throw new IllegalArgumentException("Vul de wedstrijden in");
            }
        this.wedstrijden = wedstrijden;
    }
}

