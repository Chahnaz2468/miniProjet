package entities;

import java.util.ArrayList;
import java.util.List;

public class DossierMed {
    protected int id;
    protected Patient patient;
    protected List<Ordonnance> ords ;

    public DossierMed() {
    }

    public DossierMed(int id, Patient patient, List<Ordonnance> ords) {
        this.id = id;
        this.patient = patient;
        this.ords = ords;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Ordonnance> getOrds() {
        return ords;
    }

    public void setOrds(List<Ordonnance> ords) {
        this.ords = ords;
    }
}
