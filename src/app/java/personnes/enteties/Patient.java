package personnes.enteties;

public class Patient extends Personne {
    private String dateNaissance;
    private String addresse;

    public Patient(double id, String nom, String prenom, double telephone, String dateNaissance, String addresse) {
        super(id, nom, prenom, telephone);
        this.dateNaissance = dateNaissance;
        this.addresse = addresse;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }
}
