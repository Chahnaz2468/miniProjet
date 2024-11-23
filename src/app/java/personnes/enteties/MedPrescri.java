package personnes.enteties;

public class MedPrescri extends Personne {
    private String specialite;

    public MedPrescri(double id, String nom, String prenom, double telephone, String specialite) {
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
