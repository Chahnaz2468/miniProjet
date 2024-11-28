package controllers;
import entities.MedRadio;
import ihm.MedRadioIHM;
import services.MedRadioServices;
import java.util.List;
import java.util.Scanner;

public class MedRadioController {
    private MedRadioServices mrs;

    public MedRadioController(MedRadioServices mrs) {
        this.mrs = mrs;
    }

    public MedRadioServices getMrs() {
        return mrs;
    }

    public void setMrs(MedRadioServices mrs) {
        this.mrs = mrs;
    }

    public void init(){
        MedRadioIHM ihm = new MedRadioIHM(this);
        ihm.showMedRadioMenu();
    }

    public int ajout(MedRadio medRadio) {
        return mrs.ajouterMedRadio(medRadio);
    }

    public int modif(int id,int hr) {
        return mrs.modifierMedRadio(id,hr);
    }

    public int supp(int id) {
        return mrs.supprimerMedRadio(id);
    }

    public List<MedRadio> affich(){
        return mrs.afficherMedRadios();
    }

    public MedRadio find(int id) {
        return mrs.findMedRadioById(id);
    }
}
