package be.ifosup.entities;

public class Club {

    //attributs:
    private String nom;
    private String sport;

    //constructeur:

    public Club(String nom, String sport) {
        this.nom = nom;
        this.sport = sport;
    }

    //getter setter:

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
}
