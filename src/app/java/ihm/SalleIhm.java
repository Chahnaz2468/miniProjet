package ihm;
import controllers.ControllerPrincipal;
import controllers.ExamenController;
import entities.Salle;
import entities.TypeExamen;

import java.time.LocalDateTime;
import java.util.Scanner;
import controllers.SalleController;
import exceptions.DoubleSalleException;
public class SalleIhm {
	SalleController salleController=new SalleController();

    public SalleIhm() {}

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
                    scanner = new Scanner(System.in);
                    System.out.print("Entrez le type d'examen: ");
                    String input = scanner.next().toUpperCase();
                    typeExamen = TypeExamen.valueOf(input);
                    System.out.println("Veuillez saisir la date et l'heure du rendez-vous (yyyy-MM-ddTHH:mm):");
                    String dateDebutInput = scanner.nextLine();
                    LocalDateTime dateDebut = LocalDateTime.parse(dateDebutInput);
                    ExamenController ec=new ExamenController();
                    verifierDisponibiliteSalle(findSalleByType(typeExamen),dateDebut,dateDebut.plusMinutes(ec.trouverExamen(typeExamen).getDuree()));
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

    public boolean verifierDisponibiliteSalle(Salle salle,LocalDateTime debut,LocalDateTime fin) {
        Scanner scanner = new Scanner(System.in);
        try {
            boolean disponible = salleController.verifierSalleDisponibiliteParTemps(salle.getTypeExamen(), debut, fin);
            if (disponible) {
                System.out.println("La salle est disponible pour la période donnée.");
                return true;
            } else {
                System.out.println("La salle n'est pas disponible pour cette période.");
                return false;
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Erreur : " + e.getMessage());
        }
        return false;
    }

    public Salle findSalleByType(TypeExamen typeExamen){
        return salleController.findSalleByType(typeExamen);
    }
}

    



