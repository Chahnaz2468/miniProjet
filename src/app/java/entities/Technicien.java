package entities;

public class Technicien extends Personnel {
    private String specialite;

    public Technicien(int id, String nom, String prenom, double telephone, int horaire, int annexp, String email, String specialite) {
        super(id, nom, prenom, telephone, horaire, annexp, email);
        this.specialite = specialite;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
