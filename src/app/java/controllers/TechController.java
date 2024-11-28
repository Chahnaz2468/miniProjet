package controllers;

import entities.MedRadio;
import entities.Technicien;
import ihm.MedRadioIHM;
import ihm.TechIHM;
import services.MedRadioServices;
import services.TechServices;

import java.util.List;
import java.util.Scanner;

public class TechController {
    private TechServices ts;

    public TechController(TechServices ts) {
        this.ts = ts;
    }

    public TechServices getTs() {
        return ts;
    }

    public void setTs(TechServices ts) {
        this.ts = ts;
    }

    public void init (){
        TechIHM ihm = new TechIHM(this);
        ihm.showTechMenu();
    }

    public int ajout(Technicien tech) {
        return ts.ajouterTech(tech);
    }

    public int modif(int id,int hr) {
        return ts.modifierTech(id,hr);
    }

    public int supp(int id) {
        return ts.supprimerTech(id);
    }

    public List<Technicien> affich(){
        return ts.afficherTechs();
    }

    public Technicien find(int id) {
        return ts.findTechById(id);
    }
}
