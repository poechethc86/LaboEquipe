package be.ifosup.entities;

public class Sport {

    //attributs:
    private String nomSport;

    //constructeur:
    public Sport(String nomSport) {
        this.nomSport = nomSport;
    }

    //getter setter:
    public String getNomSport() {
        return nomSport;
    }

    public void setNomSport(String nomSport) {
        this.nomSport = nomSport;
    }
}
