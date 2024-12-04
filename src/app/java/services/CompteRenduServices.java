package services;

import entities.CompteRendu;
import persistance.CompteRenduRepository;
import exceptions.DoubleCompteRenduException;

public class CompteRenduServices {
    CompteRenduRepository compteRenduRepository;
    public CompteRenduServices(CompteRenduRepository compteRenduRepository) {

        this.compteRenduRepository =compteRenduRepository;
    }
    public void ajouterCompteRendu(CompteRendu compteRendu) throws DoubleCompteRenduException {
        CompteRendu[] compteRendus = compteRenduRepository.getCompteRendus();
        for (CompteRendu cr : compteRendus) {
            if (cr != null && cr.getPatient().equals(compteRendu.getPatient())) {
                throw new DoubleCompteRenduException("Compte rendu pour le patient " +
                        compteRendu.getPatient() + " existe déjà.");
            }
        }
        for (int i = 0; i < compteRendus.length; i++) {
            if (compteRendus[i] == null) {
                compteRendus[i] = compteRendu;
                compteRenduRepository.saveCompteRendus();

            }
        }

    }

    public void modifierCompteRendu(int id, CompteRendu newCompteRendu) {
        if (id >= 0 && id < compteRenduRepository.getCompteRendus().length) {
            compteRenduRepository.getCompteRendus()[id] = newCompteRendu;
            compteRenduRepository.saveCompteRendus();
        }
    }

    public void retirerCompteRendu(int id) {
        if (id >= 0 && id < compteRenduRepository.getCompteRendus().length) {
            compteRenduRepository.getCompteRendus()[id] = null;
            compteRenduRepository.saveCompteRendus();
        }
    }

    public CompteRendu[] afficherCompteRendus() {
        return compteRenduRepository.getCompteRendus();
    }
    public boolean saveCompteRenduAsPdf(CompteRendu compteRendu) {
        return compteRenduRepository.saveCompteRenduAsPdf(compteRendu);
    }
}

