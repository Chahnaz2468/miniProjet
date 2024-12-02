package ihm;

import controllers.RendezVousController;
import entities.DossierMed;
import entities.RendezVous;
import entities.Salle;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RendezVousIHM {
    private RendezVousController rvc;

    public RendezVousIHM(RendezVousController rvc) {
        this.rvc = rvc;
    }

    public void showRendezVousMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n===== Menu Gestion des Rendez-Vous =====");
            System.out.println("1. Ajouter un Rendez-Vous");
            System.out.println("2. Modifier la Date d'un Rendez-Vous");
            System.out.println("3. Supprimer un Rendez-Vous");
            System.out.println("4. Afficher Tous les Rendez-Vous");
            System.out.println("5. Trouver un Rendez-Vous par ID");
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
                    ajouterRendezVous();
                    break;
                case 2:
                    modifierDateRendezVous();
                    break;
                case 3:
                    supprimerRendezVous();
                    break;
                case 4:
                    afficherRendezVous();
                    break;
                case 5:
                    trouverRendezVousParId();
                    break;
                case 6:
                    System.out.println("Retour au menu principal...");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choice != 6);
    }

    private void ajouterRendezVous() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir l'ID du rendez-vous:");
        int id = scanner.nextInt();
        DossierMedIHM ihm = new DossierMedIHM();
        DossierMed dossierMed=ihm.saisir();
        System.out.println("Veuillez saisir la date et l'heure du rendez-vous (yyyy-MM-ddTHH:mm):");
        scanner.nextLine();
        String dateInput = scanner.nextLine();
        LocalDateTime date = LocalDateTime.parse(dateInput);
        System.out.println("Veuillez saisir le numéro de la salle:");
        int salleNum = scanner.nextInt();
        Salle salle = new Salle();
        salle.setNum(salleNum);

        RendezVous rendezVous = new RendezVous(id, dossierMed, date, salle);
        try {
            int result = rvc.ajout(rendezVous);
            if (result == 1) {
                System.out.println("Rendez-vous ajouté avec succès.");
            } else {
                System.out.println("Erreur lors de l'ajout du rendez-vous.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }

    private void modifierDateRendezVous() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir l'ID du rendez-vous à modifier:");
        int id = scanner.nextInt();
        System.out.println("Veuillez saisir la nouvelle date et l'heure (yyyy-MM-ddTHH:mm):");
        scanner.nextLine();
        String dateInput = scanner.nextLine();
        LocalDateTime newDate = LocalDateTime.parse(dateInput);
        int result = rvc.modif(id, newDate);
        if (result == 1) {
            System.out.println("Rendez-vous modifié avec succès.");
        } else {
            System.out.println("Erreur lors de la modification du rendez-vous.");
        }
    }

    private void supprimerRendezVous() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir l'ID du rendez-vous à supprimer:");
        int id = scanner.nextInt();
        int result = rvc.supp(id);
        if (result == 1) {
            System.out.println("Rendez-vous supprimé avec succès.");
        } else {
            System.out.println("Erreur lors de la suppression du rendez-vous.");
        }
    }

    private void afficherRendezVous() {
        List<RendezVous> rendezVousList = rvc.affich();

        if (rendezVousList == null || rendezVousList.isEmpty()) {
            System.out.println("Aucun rendez-vous à afficher.");
            return;
        }

        for (RendezVous rendezVous : rendezVousList) {
            System.out.println("Rendez-Vous ID: " + rendezVous.getId());
            System.out.println("ID patient: "+ rendezVous.getDossier().getPatient().getId());
            System.out.println("Nom patient: "+ rendezVous.getDossier().getPatient().getNom());
            System.out.println("Prenom patient: "+rendezVous.getDossier().getPatient().getPrenom());
            System.out.println("  Date: " + rendezVous.getDate());
            System.out.println("  Salle: " + rendezVous.getSalle().getNum());
            System.out.println("-----------------------------");
        }
    }

    private void trouverRendezVousParId() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez saisir l'ID du rendez-vous à trouver:");
        int id = scanner.nextInt();

        RendezVous rendezVous = rvc.find(id);

        if (rendezVous == null) {
            System.out.println("Aucun rendez-vous trouvé avec cet ID.");
        } else {
            System.out.println("Rendez-Vous ID: " + rendezVous.getId());
            System.out.println("ID patient: "+ rendezVous.getDossier().getPatient().getId());
            System.out.println("Nom patient: "+ rendezVous.getDossier().getPatient().getNom());
            System.out.println("Prenom patient: "+rendezVous.getDossier().getPatient().getPrenom());
            System.out.println("  Date: " + rendezVous.getDate());
            System.out.println("  Salle: " + rendezVous.getSalle().getNum());
            System.out.println("-----------------------------");
        }
    }
}
