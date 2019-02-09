package be.ifosup.entities;

public class Membre {
    // attributs
    private String nom;
    private String prenom;
    private String password;

    // constructeur
    public Membre(String nom, String prenom, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
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
}
