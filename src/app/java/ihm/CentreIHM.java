package ihm;

import controllers.CentreController;
import controllers.ControllerPrincipal;
import entities.Centre;
import java.util.Scanner;

public class CentreIHM {
    private CentreController centreController;

    public CentreIHM(CentreController centreController) {
        this.centreController = centreController;
    }

    public void showCentreMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== Menu Gestion du Centre =====");
            System.out.println("1. Ajouter les informations du Centre");
            System.out.println("2. Afficher le Centre");
            System.out.println("3. Modifier le Centre");
            System.out.println("4. Retour au Menu Principal");
            System.out.print("Choisissez une option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Centre centre = saisirCentre(scanner);
                    centreController.ajouterCentre(centre);
                    System.out.println("Centre ajouté avec succès !");
                    break;
                case 2:
                    Centre c = centreController.afficherCentre();
                    if (c != null) {
                        System.out.println("Nom: " + c.getNom());
                        System.out.println("Adresse: " + c.getAdresse());
                        System.out.println("Numéro de téléphone: " + c.getNumTel());
                    } else {
                        System.out.println("Aucun centre trouvé.");
                    }
                    break;
                case 3:
                    System.out.println("Entrez les nouvelles informations du centre:");
                    Centre newCentre = saisirCentre(scanner);
                    centreController.modifierCentre(newCentre);
                    System.out.println("Centre modifié avec succès !");
                    break;
                case 4:
                    ControllerPrincipal controllerPrincipal = new ControllerPrincipal();
                    controllerPrincipal.init();
                    break;
                default:
                    System.out.println("Option invalide.");
            }
        } while (choice != 4);
    }

    private Centre saisirCentre(Scanner scanner) {
        System.out.println("Nom du centre:");
        String nom = scanner.next();
        System.out.println("Adresse du centre:");
        String adresse = scanner.next();
        System.out.println("Numéro de téléphone du centre:");
        String numTel = scanner.next();
        return new Centre(nom, adresse, numTel);
    }
}
