package services;
import entities.MedPrescri;
import persistance.MedPrescriRepository;

import java.util.List;

public class MedPrescriServices {

    public int ajouterMedPrescri(MedPrescri medPrescri) {
        return MedPrescriRepository.ajouterMedPriscri(medPrescri);
    }

    public int modifierTelephoneMedPrescri(int id, double telephone) {
        return MedPrescriRepository.modifierTelephoneMedPrescri(id,telephone);
    }

    public int supprimerMedPrescri(int id) {
        return MedPrescriRepository.supprimerMedPrescri(id);
    }

    public List<MedPrescri> afficherMedprescris () {
        return MedPrescriRepository.afficherMedPrescris();
    }

    public MedPrescri findMedPrescriById(int id) {
        return MedPrescriRepository.findMedPrescriById(id);
    }
}
