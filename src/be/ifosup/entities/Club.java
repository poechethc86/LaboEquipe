package be.ifosup.entities;

public class Club {

    //attributs:
    private String nom;
    private String sport;
    private int pk_club;
    private int memberCount;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Club)) return false;

        Club club = (Club) o;

        return getNom() != null ? getNom().equals(club.getNom()) : club.getNom() == null;
    }

    @Override
    public int hashCode() {
        return getNom() != null ? getNom().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "nom='" + nom + '\'' +
                ", sport='" + sport + '\'' +
                ", pkClub='" + pk_club + '\'' +
                ", memberCount='" + memberCount + '\'' +
                '}';
    }


}
