package ihm;
import controllers.ControllerPrincipal;
import entities.Salle;
import entities.TypeExamen;

import java.time.LocalDateTime;
import java.util.Scanner;
import controllers.SalleController;
import exceptions.DoubleSalleException;
public class SalleIhm {
	SalleController salleController;

    public SalleIhm(SalleController salleController) {

        this.salleController = salleController;
	}

    public void showSalleMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== Menu Gestion des Salles =====");
            System.out.println("1. Ajouter une Salle");
            System.out.println("2. Afficher les Salles");
            System.out.println("3. modifier les Salles");
            System.out.println("4. retirer les Salles");
            System.out.println("5. Vérifier Disponibilité Salle");
            System.out.println("6. Retour au Menu Principal");
            System.out.print("Choisissez une option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Salle salle = saisirSalle();
                    try {
                        salleController.ajouterSalle(salle);
                        System.out.println("Salle ajoutée avec succès !");
                    } catch (DoubleSalleException e) {
                        System.err.println("Erreur : " + e.getMessage());
                    }
                    break;
                case 2:
                    Salle[] salles = salleController.afficherSalles();
                    if (salles != null) {
                        for (Salle s : salles) {
                            if (s != null) {
                                System.out.printf("Salle numéro: %d, Type: %s, Disponibilité: %b\n", s.getNum(), s.getTypeExamen(), s.getDisponibilite());
                            }
                        }
                    } else {
                        System.out.println("Aucune salle disponible.");
                    }
                    break;
                case 3:
                    System.out.println("Entrez le numéro de la salle à modifier:");
                    int num = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Entrez le nouveau type d'examen:");
                    for (TypeExamen type : TypeExamen.values()) {
                        System.out.println("- " + type);
                    }
                    String typeInput = scanner.nextLine().toUpperCase();
                    TypeExamen typeExamen = TypeExamen.valueOf(typeInput);
                    System.out.println("Entrez la nouvel état de disponibilité de la salle :(true/false)");
                    boolean disponibilite = scanner.nextBoolean();

                    Salle newSalle = new Salle(num,typeExamen,disponibilite);
                    salleController.modifiererSalle(num, newSalle);
                    System.out.println("la Salle est modifiée.");
                    break;
                case 4:
                    System.out.println("Entrez le numéro de la salle à retirer:");
                    num = scanner.nextInt();
                    salleController.retirerSalle(num);
                    System.out.println("la Salle est retirée.");
                    break;
                case 5:
                    verifierDisponibiliteSalle();
                    break;
                case 6:
                    ControllerPrincipal controllerPrincipal = new ControllerPrincipal();
                    controllerPrincipal.init();
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choice != 6);
    }

    public Salle saisirSalle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le numéro de la salle:");
        int num = scanner.nextInt();
        System.out.println("La salle est-elle disponible ? (true/false):");
        boolean disponibilite = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("Choisir le type d'examen:");
        for (TypeExamen type : TypeExamen.values()) {
            System.out.println("- " + type);
        }
        TypeExamen typeExamen = null;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Entrez le type d'examen: ");
            String typeInput = scanner.nextLine().toUpperCase();
            for (TypeExamen type : TypeExamen.values()) {
                if (type.name().equals(typeInput)) {
                    typeExamen = type;
                    validInput = true;
                    break;
                }
            }
            if (!validInput) {
                System.out.println("Type d'examen incorrect. Veuillez entrer un type exact parmi la liste.");
            }
        }
        return new Salle(num, typeExamen, disponibilite);
    }

    public void verifierDisponibiliteSalle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir le type d'examen fait dans cette salle(RADIOGRAPHIE, ECHOGRAPHIE, MAMMOGRAPHIE, DOPPLER, SCANNER, IRM): ");
        String input = scanner.next().toUpperCase();;
        TypeExamen typeExamen = TypeExamen.valueOf(input);
        System.out.println("Entrez la date et l'heure de début (yyyy-MM-ddTHH:mm):");
        scanner.nextLine();
        String debutInput = scanner.nextLine();
        LocalDateTime debut = LocalDateTime.parse(debutInput);
        System.out.println("Entrez la date et l'heure de fin (yyyy-MM-ddTHH:mm):");
        String finInput = scanner.nextLine();
        LocalDateTime fin = LocalDateTime.parse(finInput);
        try {
            boolean disponible = salleController.verifierSalleDisponibiliteParTemps(typeExamen, debut, fin);
            if (disponible) {
                System.out.println("La salle est disponible pour la période donnée.");
            } else {
                System.out.println("La salle n'est pas disponible pour cette période.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}

    



