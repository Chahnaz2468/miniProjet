package ihm;

import controllers.FinanceController;
import entities.Finance;

import java.util.List;
import java.util.Scanner;

public class FinanceIHM {
    private FinanceController fc;

    public FinanceIHM(FinanceController fc) {
        this.fc = fc;
    }

    public FinanceController getFc() {
        return fc;
    }

    public void setFc(FinanceController fc) {
        this.fc = fc;
    }

    public void showFinanceMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("\n===== Menu Gestion de Finance =====");
            System.out.println("1. Ajouter un montant au depenses");
            System.out.println("2. Afficher les depenses");
            System.out.println("3. Afficher le total des depenses");
            System.out.println("4. Afficher le total des revenus");
            System.out.println("5. Afficher le total");
            System.out.println("6. Retour au Menu Principal");
            System.out.print("Choisissez une option: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Entrée invalide. Veuillez entrer un entier.");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1:
                    this.saisir();
                    break;
                case 2:
                    this.afficherDepenses();
                    break;
                case 3:
                    this.afficherTotalDepenses();
                    break;
                case 4:
                    this.afficherTotalRevenus();
                    break;
                case 5:
                    this.afficherTotal();
                    break;
                case 6:
                    System.out.println("Retour au menu principal...");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choice != 6);
    }

    public void saisir() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir le montant: ");
        double montant = scanner.nextDouble();
        System.out.println("Veuillez saisir la description: ");
        String description = scanner.next();
        Finance finance = new Finance(montant,
                description);
        if (fc.ajout(finance) == 1)
            System.out.println("Montant ajouté avec succès ");
        else
            System.out.println("Erreur");
    }

    public void afficherDepenses() {
        List<Finance> finances = fc.affich();
        if (finances == null || finances.isEmpty()) {
            System.out.println("Aucun depense à afficher.");
        }
        for (Finance finance : finances) {
            System.out.println("Depense");
            System.out.println("Montant: "+finance.getDepense());
            System.out.println("Description: "+finance.getDescription());
            System.out.println("-----------------------------");
        }
    }

    public void afficherTotalDepenses() {
        System.out.println("Total de depenses: "+fc.affichTotalDepense());
    }

    public void afficherTotalRevenus() {
        System.out.println("Total de revenus: "+fc.affichTotalRevenu());
    }

    public void afficherTotal() {
        double total =fc.affichTotalRevenu()-fc.affichTotalDepense() ;
        System.out.println("Total: "+ total);
    }
}
