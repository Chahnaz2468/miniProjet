package ihm;

import controllers.ExamenController;
import controllers.RendezVousController;
import entities.DossierMed;
import entities.Examen;
import entities.RendezVous;
import entities.Salle;
import java.time.LocalDateTime;
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
        scanner.nextLine();
        DossierMedIHM ihm = new DossierMedIHM();
        DossierMed dossierMed=ihm.saisir();
        SalleIhm sihm=new SalleIhm();
        Salle salle = sihm.findSalleByType(dossierMed.getOrds().getLast().getTypeExamen());
        scanner.nextLine();
        System.out.println("Veuillez saisir la date et l'heure du rendez-vous (yyyy-MM-ddTHH:mm):");
        String dateDebutInput = scanner.nextLine();
        while (dateDebutInput.trim().isEmpty()) {
            System.out.println("La date et l'heure ne peuvent pas être vides. Veuillez réessayer:");
            dateDebutInput = scanner.nextLine();
        }
        LocalDateTime dateDebut = LocalDateTime.parse(dateDebutInput);
        ExamenController ec=new ExamenController();
        LocalDateTime dateFin = dateDebut.plusMinutes(ec.trouverExamen(dossierMed.getOrds().getLast().getTypeExamen()).getDuree());
        boolean ok=sihm.verifierDisponibiliteSalle(salle,dateDebut,dateFin);
        if (ok==false) {
            System.out.println("Veuillez saisir une autre date: ");
            dateDebutInput = scanner.nextLine();
            dateDebut = LocalDateTime.parse(dateDebutInput);
        }
        RendezVous rendezVous = new RendezVous(id, dossierMed, dateDebut, salle);
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
