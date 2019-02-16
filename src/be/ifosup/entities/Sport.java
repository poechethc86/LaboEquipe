package be.ifosup.entities;

public class Sport {

    //attributs:
    private String nomSport;
    private int pk_sport;

    //constructeur:
    public Sport(String nomSport,int pk_sport) {
        this.nomSport = nomSport;
        this.pk_sport = pk_sport;
    }

    //getter setter:
    public String getNomSport() {
        return nomSport;
    }

    public void setNomSport(String nomSport) {
        this.nomSport = nomSport;
    }

    public int getPk_sport() {
        return pk_sport;
    }

    public void setPk_sport(int pk_sport) {
        this.pk_sport = pk_sport;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "pkSport='" + pk_sport + '\'' +
                ", nomSport='" + nomSport + '\'' +
                '}';
    }
}
