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

    public void showTechMenu() {
        Scanner scanner = new Scanner(System.in);
        TechIHM ihm = new TechIHM(this);
        int choice = 0;
        do {
            System.out.println("\n===== Menu Gestion des techniciens =====");
            System.out.println("1. Ajouter un technicien");
            System.out.println("2. Modifier un technicien");
            System.out.println("3. Retirer un technicien");
            System.out.println("4. Trouver un technicien");
            System.out.println("5. Afficher les techniciens");
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
                    ihm.saisir();
                    break;
                case 2:
                    ihm.modifierHorraireTech();
                    break;
                case 3:
                    ihm.supprimerTech();
                    break;
                case 4:
                    ihm.findTechById();
                    break;
                case 5:
                    ihm.afficherTech();
                    break;
                case 6:
                    System.out.println("Retour au menu principal...");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choice != 6);
    }

    public int init(Technicien tech) {
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
