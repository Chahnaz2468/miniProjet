package services;
import entities.Examen;
import entities.TypeExamen;
import persistance.ExamenRepository;
import java.util.List;

public class ExamenServices {

    public ExamenServices() {}

    public int ajouterExamen(Examen examen) {
        return ExamenRepository.ajouterExamen(examen);
    }

    public int modifierExamen(TypeExamen typeExamen,float cout) {
        return ExamenRepository.modifierCoutExamen(typeExamen,cout);
    }

    public int supprimerExamen(TypeExamen typeExamen) {
        return ExamenRepository.supprimerExamen(typeExamen);
    }

    public List<Examen> afficherExamens (){
        return ExamenRepository.afficherExamens();
    }

    public Examen trouverExamenParType(TypeExamen typeExamen) {
        return ExamenRepository.trouverExamenParType(typeExamen);
    }
}
