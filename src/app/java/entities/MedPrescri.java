package entities;

public class MedPrescri extends Personne {
    private String specialite;

    public MedPrescri() {
    }

    public MedPrescri(int id, String nom, String prenom, String telephone, String specialite) {
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
