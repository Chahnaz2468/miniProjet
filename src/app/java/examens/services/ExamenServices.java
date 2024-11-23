package examens.services;
import examens.entities.Examen;
import examens.entities.TypeExamen;
import examens.persistance.ExamenRepository;

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
