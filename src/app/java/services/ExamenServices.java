package services;
import entities.Examen;
import entities.TypeExamen;
import persistance.ExamenRepository;

public class ExamenServices {
    public void ajouterExamen(Examen examen) {
        ExamenRepository.ajouterExamen(examen);
    }

    public void modifierExamen(TypeExamen typeExamen,float cout) {
        ExamenRepository.modifierCoutExamen(typeExamen,cout);
    }

    public void supprimerExamen(TypeExamen typeExamen) {
        ExamenRepository.supprimerExamen(typeExamen);
    }

}
