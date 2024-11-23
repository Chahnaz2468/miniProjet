package controllers;
import entities.MedPrescri;
import services.MedPrescriServices;
import ihm.MedPrescriIHM;

public class MedPrescriController {
    private MedPrescriServices mps;

    public MedPrescriController(MedPrescriServices mps) {
        this.mps = mps;
    }

    public MedPrescriServices getMps() {
        return mps;
    }

    public void setMps(MedPrescriServices mps) {
        this.mps = mps;
    }

    public void init(MedPrescri medPrescri) {
        MedPrescriIHM.saisir(medPrescri);
        mps.ajouterMedPrescri(medPrescri);
    }

    public void modif() {
        double id=0; double num=0;
        MedPrescriIHM.modifierTelphoneMedPrescri(id,num);
        mps.modifierTelephoneMedPrescri(id,num);
    }

    public void supp(){
        double id=MedPrescriIHM.supprimerMedPrescri();
        mps.supprimerMedPrescri(id);
    }
}
