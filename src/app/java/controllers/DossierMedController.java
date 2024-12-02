package controllers;

import entities.DossierMed;
import entities.TypeExamen;
import ihm.DossierMedIHM;
import services.DossierMedServices;

import java.util.List;

public class DossierMedController {
    private DossierMedServices dms;

    public DossierMedController(DossierMedServices dms) {
        this.dms = dms;
    }

    public DossierMedServices getDms() {
        return dms;
    }

    public void setDms(DossierMedServices dms) {
        this.dms = dms;
    }

    public void init(){
        DossierMedIHM ihm = new DossierMedIHM(this);
        ihm.showDossierMedMenu();
    }

    public int ajout(DossierMed dossierMed) {
        return dms.ajouterDossierMed(dossierMed);
    }

    public int modif(int id,TypeExamen typeExamen) {
        return dms.modifierTypeExLastOrd(id,typeExamen);
    }

    public int supp(int id) {
        return dms.supprimerDossierMed(id);
    }

    public List<DossierMed> affich(){
        return dms.afficherDossierMeds();
    }

    public DossierMed find(int id) {
        return dms.findDossierMedByPatientId(id);
    }
}
