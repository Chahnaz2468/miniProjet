package services;

import entities.Finance;
import persistance.FinanceRepository;

import java.util.List;

public class FinanceServices {
    public int ajouterMontant(Finance finance) {
        return FinanceRepository.ajouterMontant(finance);
    }

    public List<Finance> afficherDepenses (){
        return FinanceRepository.afficherdepenses();
    }

    public double afficherTotalDepense(){
        return FinanceRepository.afficherTotalDepense();
    }

    public double afficherTotalRevenu(){
        return FinanceRepository.afficherTotalRevenu();
    }
}
