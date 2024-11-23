package services;
import entities.MedPrescri;
import persistance.MedPrescriRepository;

public class MedPrescriServices {
    public void ajouterMedPrescri(MedPrescri medPrescri) {
        MedPrescriRepository.ajouterMedPriscri(medPrescri);
    }

    public void modifierTelephoneMedPrescri(double id, double telephone) {
        MedPrescriRepository.modifierTelephoneMedPrescri(id,telephone);
    }

    public void supprimerMedPrescri(double id) {
        MedPrescriRepository.supprimerMedPrescri(id);
    }
}
