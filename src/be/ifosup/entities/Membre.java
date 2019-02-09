package be.ifosup.entities;

public class Membre {
    // attributs
    private String nom;
    private String prenom;
    private String password;
    private String user;

    // constructeur
    public Membre(String nom, String prenom, String password, String user) {
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.user = user;
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
}
