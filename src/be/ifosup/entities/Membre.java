package be.ifosup.entities;

public class Membre {
    // attributs
    private String nom;
    private String prenom;
    private String password;
    private String user;
    private int pk_membre;

    // constructeur
    public Membre(String nom, String prenom, String password, String user, int pk_membre) {
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.user = user;
        this.pk_membre = pk_membre;

    }
    public Membre(String nom, String prenom){
        this(nom,prenom,"", "",-1);
    }


    // Getters & Setters
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public int getPk_membre() {
        return pk_membre;
    }

    public void setPk_membre(int pk_membre) {
        this.pk_membre = pk_membre;
    }
/*
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(!(o instanceof Membre)) return false;
        Membre membre =(Membre) o;
        return getPk_membre() != null ? getPk_membre().equals(membre.getPk_membre()): membre.getPk_membre() == null;

    }
    @Override
    public int hashCode() {
        return getPk_membre() != null ? getPk_membre().hashCode() : 0;
    }
*/
    @Override
    public String toString() {
        return "Membre{" +
                "idMembre='" + pk_membre + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", password='" + password + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
