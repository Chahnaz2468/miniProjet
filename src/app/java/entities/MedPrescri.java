package entities;

public class MedPrescri extends Personne {
    private String specialite;

    public MedPrescri() {
    }

    public MedPrescri(int id, String nom, String prenom, double telephone, String specialite) {
        super(id, nom, prenom, telephone);
        this.specialite = specialite;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
