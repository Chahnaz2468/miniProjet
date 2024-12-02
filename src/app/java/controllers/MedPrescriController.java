package controllers;
import entities.MedPrescri;
import services.MedPrescriServices;
import ihm.MedPrescriIHM;
import java.util.List;
import java.util.Scanner;

public class MedPrescriController {
    private MedPrescriServices mps=new MedPrescriServices();

    public MedPrescriController() {
    }

    public MedPrescriController(MedPrescriServices mps) {
        this.mps = mps;
    }

    public MedPrescriServices getMps() {
        return mps;
    }

    public void setMps(MedPrescriServices mps) {
        this.mps = mps;
    }

    public void init(){
        MedPrescriIHM ihm = new MedPrescriIHM(this);
        ihm.showMedPrescriMenu();
    }

    public int ajout(MedPrescri medPrescri) {
        return mps.ajouterMedPrescri(medPrescri);
    }

    public int modif(int id,double num) {
        return mps.modifierTelephoneMedPrescri(id,num);
    }

    public int supp(int id){
        return mps.supprimerMedPrescri(id);
    }

    public List<MedPrescri> affich(){
        return mps.afficherMedprescris();
    }

    public MedPrescri find(int id) {
        return mps.findMedPrescriById(id);
    }
}
