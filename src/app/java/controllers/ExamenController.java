package controllers;
import entities.Examen;
import entities.TypeExamen;
import services.ExamenServices;
import ihm.ExamenIHM;
import java.util.List;
import java.util.Scanner;

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

    public void init(){
        ExamenIHM ihm = new ExamenIHM(this);
        ihm.showExamenMenu();
    }

    public int ajout(Examen examen) {
        return es.ajouterExamen(examen);
    }

    public int modif(TypeExamen typeExamen, float cout) {
        return es.modifierExamen(typeExamen,cout);
    }

    public int supp(TypeExamen typeExamen) {
        return es.supprimerExamen(typeExamen);
    }

    public List<Examen> affich(){
        return es.afficherExamens();
    }

    public Examen trouverExamen(TypeExamen typeExamen) {
        return es.trouverExamenParType(typeExamen);
    }
}