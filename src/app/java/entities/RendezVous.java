package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RendezVous {
    private int id;
    private DossierMed dossier;
    private LocalDateTime date;
    private Salle salle;

    public RendezVous(int id, DossierMed dossier, LocalDateTime date, Salle salle) {
        this.id = id;
        this.dossier = dossier;
        this.date = date;
        this.salle = salle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DossierMed getDossier() {
        return dossier;
    }

    public void setDossier(DossierMed dossier) {
        this.dossier = dossier;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
}
