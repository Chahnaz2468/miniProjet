package controllers;

import entities.DossierMed;
import entities.Examen;
import entities.Finance;
import services.CompteRenduServices;
import entities.CompteRendu;
import ihm.CompteRenduIHM;
import exceptions.DoubleCompteRenduException;

public class CompteRenduController {
    private CompteRenduServices compteRenduService;

    public CompteRenduController(CompteRenduServices compteRenduService) {
        this.compteRenduService = compteRenduService;
    }

    public void init() {
        CompteRenduIHM compteRenduIhm = new CompteRenduIHM(this);
        compteRenduIhm.showCompteRenduMenu();
    }

    public void ajouterCompteRendu(CompteRendu compteRendu) throws DoubleCompteRenduException {
        compteRenduService.ajouterCompteRendu(compteRendu);
        DossierMedController dmc=new DossierMedController();
        DossierMed dossierMed=dmc.find(compteRendu.getPatient().getId());
        ExamenController ec=new ExamenController();
        Examen examen=ec.trouverExamen(dossierMed.getOrds().getLast().getTypeExamen());
        FinanceController fc=new FinanceController();
        String descri="Cout visite patient d'id: "+compteRendu.getPatient().getId();
        fc.ajout(new Finance(descri,examen.getCout()));
    }

    public CompteRendu[] afficherCompteRendus() {
        return compteRenduService.afficherCompteRendus();
    }

    public void modifierCompteRendu(int id, CompteRendu newCompteRendu) {
        compteRenduService.modifierCompteRendu(id, newCompteRendu);
    }

    public void retirerCompteRendu(int id) {
        compteRenduService.retirerCompteRendu(id);
    }
    public boolean saveCompteRenduAsPdf(CompteRendu compteRendu) {
        return compteRenduService.saveCompteRenduAsPdf(compteRendu);
    }
}
