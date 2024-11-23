package controllers;
import entities.Examen;
import entities.TypeExamen;
import services.ExamenServices;
import ihm.ExamenIHM;

public class ExamenController {
    private ExamenServices es;

    public ExamenController(ExamenServices es) {
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
