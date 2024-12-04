package controllers;

import entities.Finance;
import ihm.FinanceIHM;
import services.FinanceServices;

import java.util.List;

public class FinanceController {
    private FinanceServices fs;

    public FinanceController() {
    }

    public FinanceController(FinanceServices fs) {
        this.fs = fs;
    }

    public FinanceServices getFs() {
        return fs;
    }

    public void setFs(FinanceServices fs) {
        this.fs = fs;
    }

    public void init (){
        FinanceIHM ihm = new FinanceIHM(this);
        ihm.showFinanceMenu();
    }

    public int ajout(Finance finance) {
        return fs.ajouterMontant(finance);
    }

    public List<Finance> affich(){
        return fs.afficherDepenses();
    }

    public double affichTotalDepense(){
        return fs.afficherTotalDepense();
    }

    public double affichTotalRevenu(){
        return fs.afficherTotalRevenu();
    }
}
