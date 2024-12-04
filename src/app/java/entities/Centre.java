package entities;

public class Centre {
    private String nom;
    private String adresse;
    private String numTel;

    public Centre() {
    }

    public Centre(String nom, String adresse, String numTel) {
        this.nom = nom;
        this.adresse = adresse;
        this.numTel = numTel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }
}
