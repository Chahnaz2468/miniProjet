package controllers;

import entities.Centre;
import services.CentreServices;
import ihm.CentreIHM;


public class CentreController {
    private CentreServices centreService;

    public CentreController(CentreServices centreService) {
        this.centreService = centreService;
    }

    public void init() {
        CentreIHM centreIhm = new CentreIHM(this);
        centreIhm.showCentreMenu();
    }

    public void ajouterCentre(Centre centre) {
        centreService.ajouterCentre(centre);
    }

    public Centre afficherCentre() {
        return centreService.afficherCentre();
    }

    public void modifierCentre(Centre newCentre) {
        centreService.modifierCentre(newCentre);
    }
}
