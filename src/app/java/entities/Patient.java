package entities;

public class Patient extends Personne {
    private String dateNaissance;
    private String addresse;

    public Patient(){}

    public Patient(int id, String nom, String prenom, String telephone, String dateNaissance, String addresse) {
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

    public void afficherPatient(Patient patient) {
        System.out.println("patient");
        System.out.println("  ID: " + patient.getId());
        System.out.println("  Nom: " + patient.getNom());
        System.out.println("  Prenom: " + patient.getPrenom());
        System.out.println("  telephone: " + patient.getTelephone());
        System.out.println("  date de naissance: " + patient.getDateNaissance());
        System.out.println("  addresse: " + patient.getAddresse());
        System.out.println("-----------------------------");
    }
}
