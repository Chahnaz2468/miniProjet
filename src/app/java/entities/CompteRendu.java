package entities;

public class CompteRendu {
    private MedRadio medRadio;
    private Patient patient;
    private String contenu;
    private int id;


    public CompteRendu(int id,String contenu, Patient patient,MedRadio medRadio) {
        this.medRadio = medRadio;
        this.patient = patient;
        this.contenu = contenu;
        this.id=id;

    }

    public MedRadio getMedRadio() { return medRadio; }
    public void setMedRadio(MedRadio medRadio) { this.medRadio = medRadio; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public String getContenu() { return contenu; }
    public void setContenu(String contenu) { this.contenu = contenu; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}
