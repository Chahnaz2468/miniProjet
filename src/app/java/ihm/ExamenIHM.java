package ihm;
import entities.Examen;
import entities.TypeExamen;

import java.util.List;
import java.util.Scanner;
import controllers.ExamenController;

public class ExamenIHM {
    private ExamenController ec=new ExamenController();

    public ExamenIHM() {}

    public ExamenIHM(ExamenController ec) {
        this.ec = ec;
    }

    public ExamenController getEc() {
        return ec;
    }

    public void setEc(ExamenController ec) {
        this.ec = ec;
    }

    public void showExamenMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("\n===== Menu Gestion des Examens =====");
            System.out.println("1. Ajouter un examen");
            System.out.println("2. Modifier un examen");
            System.out.println("3. Retirer un examen");
            System.out.println("4. Afficher les examens");
            System.out.println("5. Trouver un examen par type");
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
                    this.modifierCout();
                    break;
                case 3:
                    this.supprimerExamen();
                    break;
                case 4:
                    this.afficherExamen();
                    break;
                case 5:
                    this.trouverExamen();
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
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le type d'examen (RADIOGRAPHIE, ECHOGRAPHIE, MAMMOGRAPHIE, DOPPLER, SCANNER, IRM): ");
        String input = sc.next().toUpperCase();
        TypeExamen typeExamen = null;
        try {
            typeExamen = TypeExamen.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Type d'examen invalide! Veuillez entrer un type correct.");
        }
        System.out.println("Veuillez saisir le cout de l'examen: ");
        float coutExamen = sc.nextFloat();
        System.out.println("Veuillez saisir la duree de l'examen: ");
        int dureeExamen = sc.nextInt();
        Examen ex = new Examen(typeExamen, coutExamen, dureeExamen);
        if (ec.ajout(ex) ==1)
            System.out.println("Examen ajouté avec succès ");
        else
            System.out.println("Erreur");
    }

    public void modifierCout() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le type d'examen à modifier: ");
        String input = sc.next().toUpperCase();
        TypeExamen typeExamen = TypeExamen.valueOf(input);
        System.out.println("Veuillez saisir le nouveau cout de l'examen: ");
        float cout = sc.nextFloat();
        if (ec.modif(typeExamen,cout) ==1)
            System.out.println("Modification faite avec succès ");
        else
            System.out.println("Erreur");
    }

    public void supprimerExamen() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le type d'examen à supprimer: ");
        String input = sc.next().toUpperCase();
        try {
            TypeExamen typeExamen = TypeExamen.valueOf(input);
            if (ec.supp(typeExamen) == 1) {
                System.out.println("Suppression faite avec succès.");
            } else {
                System.out.println("Aucun examen de ce type trouvé.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Type d'examen invalide. Veuillez réessayer.");
        }
    }

    public void afficherExamen() {
        List<Examen> examens=ec.affich();
        if (examens == null || examens.isEmpty()) {
            System.out.println("Aucun examen à afficher.");
            return;
        }

        for (Examen examen : examens) {
            System.out.println("Examen:");
            System.out.println("  Type d'examen: " + examen.getTypeExamen());
            System.out.println("  Coût: " + examen.getCout());
            System.out.println("  Durée: " + examen.getDuree());
            System.out.println("-----------------------------");
        }
    }

    public void trouverExamen() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le type d'examen à rechercher: ");
        String input = sc.next().toUpperCase();
        TypeExamen typeExamen;
        try {
            typeExamen = TypeExamen.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Type d'examen invalide! Veuillez entrer un type correct.");
            return;
        }

        Examen examen = ec.trouverExamen(typeExamen);
        if (examen != null) {
            System.out.println("Examen trouvé:");
            System.out.println("  Type d'examen: " + examen.getTypeExamen());
            System.out.println("  Coût: " + examen.getCout());
            System.out.println("  Durée: " + examen.getDuree());
        } else {
            System.out.println("Aucun examen trouvé pour le type spécifié.");
        }
    }
}