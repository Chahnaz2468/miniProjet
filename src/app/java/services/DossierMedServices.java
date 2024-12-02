package services;

import entities.DossierMed;
import entities.TypeExamen;
import persistance.DossierMedRepository;

import java.util.List;

public class DossierMedServices {
    public int ajouterDossierMed(DossierMed dossierMed) {
        return DossierMedRepository.ajouterDossierMed(dossierMed);
    }

    public int modifierTypeExLastOrd(int id,TypeExamen typeExamen) {
        return DossierMedRepository.modifierTypeExLastOrd(id,typeExamen);
    }

    public int supprimerDossierMed(int id) {
        return DossierMedRepository.supprimerDossierMed(id);
    }

    public List<DossierMed> afficherDossierMeds (){
        List<DossierMed> dossierMeds = DossierMedRepository.afficherDossierMeds();
        if (dossierMeds == null) {
            throw new RuntimeException("Erreur lors de la récupération des dossiers.");
        }
        return dossierMeds;
    }

    public DossierMed findDossierMedByPatientId(int id) {
        DossierMed dossier = DossierMedRepository.findDossierMedByPatientId(id);
        /*if (dossier == null) {
            throw new IllegalArgumentException("Aucun dossier trouvé pour l'ID patient: " + id);
        }*/
        return dossier;
    }
}
