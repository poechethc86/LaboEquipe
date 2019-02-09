package be.ifosup.entities;

public class Club {

    //attributs:
    private String nom;
    private String sport;
    private int pk_club;

    //constructeur:

    public Club(String nom, String sport, int pk_club) {
        this.nom = nom;
        this.sport = sport;
        this.pk_club= pk_club;
    }
    public Club(String nom) {
        this(nom,"",-1);
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

    public int getPk_club() {
        return pk_club;
    }

    public void setPk_club(int pk_club) {
        this.pk_club = pk_club;
    }
}
