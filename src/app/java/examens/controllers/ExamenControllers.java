package examens.controllers;
import examens.entities.Examen;
import examens.entities.TypeExamen;
import examens.services.ExamenServices;
import examens.ihm.ExamenIHM;
public class ExamenControllers {
    protected ExamenServices es;

    public ExamenControllers(ExamenServices es) {
        this.es = es;
    }

    public ExamenServices getEs() {
        return es;
    }

    public void setEs(ExamenServices es) {
        this.es = es;
    }

    public void init(Examen examen) {
        ExamenIHM.saisir(examen);
        es.ajouterExamen(examen);
    }

    public void modif() {
        TypeExamen typeExamen=null; float cout=0;
        ExamenIHM.modifierCout(typeExamen,cout);
        es.modifierExamen(typeExamen,cout);
    }

    public void supp(){
        TypeExamen typeExamen=ExamenIHM.supprimerExamen();
        es.supprimerExamen(typeExamen);
    }
}
