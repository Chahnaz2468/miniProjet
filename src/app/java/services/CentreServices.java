package services;

import entities.Centre;
import persistance.CentreRepository;

public class CentreServices {
    private CentreRepository centreRepository;

    public CentreServices(CentreRepository centreRepository) {
        this.centreRepository = centreRepository;
        this.centreRepository.loadCentre();
    }

    public void ajouterCentre(Centre centre) {
        centreRepository.setCentre(centre);
        centreRepository.saveCentre();
    }

    public Centre afficherCentre() {
        return centreRepository.getCentre();
    }

    public void modifierCentre(Centre newCentre) {
        centreRepository.setCentre(newCentre);
        centreRepository.saveCentre();
    }
}
