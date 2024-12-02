package controllers;

import entities.RendezVous;
import ihm.DossierMedIHM;
import ihm.RendezVousIHM;
import services.RendezVousServices;
import services.SalleService;

import java.time.LocalDateTime;
import java.util.List;

public class RendezVousController {
    private RendezVousServices rvs;
    private SalleController sc;
    private ExamenController ec;

    public RendezVousController(RendezVousServices rvs) {
        this.rvs = rvs;
    }

    public RendezVousServices getRvs() {
        return rvs;
    }

    public void setRvs(RendezVousServices rvs) {
        this.rvs = rvs;
    }

    public void init(){
        RendezVousIHM ihm = new RendezVousIHM(this);
        ihm.showRendezVousMenu();
    }

    public int ajout(RendezVous rendezVous) {
        boolean isAvailable = sc.verifierSalleDisponibiliteParTemps(
                rendezVous.getSalle().getTypeExamen(),
                rendezVous.getDate(),
                rendezVous.getDate().plusMinutes(ec.trouverExamen(rendezVous.getSalle().getTypeExamen()).getDuree()));
        if (isAvailable) {
            return rvs.ajouterRendezVous(rendezVous);
        } else {
            throw new IllegalArgumentException("La salle n'est pas disponible pour cette période.");
        }
    }

    public int modif(int id, LocalDateTime date) {
        return rvs.modifierDateRendezVous(id,date);
    }

    public int supp(int id) {
        return rvs.supprimerRendezVous(id);
    }

    public List<RendezVous> affich(){
        return rvs.afficherRendezVouss();
    }

    public RendezVous find(int id) {
        return rvs.findRendezVousById(id);
    }
}
