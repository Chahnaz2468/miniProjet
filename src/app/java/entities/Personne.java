package entities;

public class Personne {
    protected int id;
    protected String nom;
    protected String prenom;
    protected double telephone;

    public Personne() {
    }

    public Personne(int id, String nom, String prenom, double telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public double getTelephone() {
        return telephone;
    }

    public void setTelephone(double telephone) {
        this.telephone = telephone;
    }
}
