package controllers;
import entities.Examen;
import entities.TypeExamen;
import services.ExamenServices;
import ihm.ExamenIHM;
import java.util.List;
import java.util.Scanner;

public class ExamenController {
    private ExamenServices es;

    public ExamenController(ExamenServices es) {
        this.es = es;
    }

    public ExamenServices getEs() {
        return es;
    }

    public void setEs(ExamenServices es) {
        this.es = es;
    }

    public void showExamenMenu() {
        Scanner scanner = new Scanner(System.in);
        ExamenIHM ihm = new ExamenIHM(this);
        int choice = 0;
        do {
            System.out.println("\n===== Menu Gestion des Examens =====");
            System.out.println("1. Ajouter un examen");
            System.out.println("2. Modifier un examen");
            System.out.println("3. Retirer un examen");
            System.out.println("4. Afficher les examens");
            System.out.println("5. Retour au Menu Principal");
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
                    ihm.modifierCout();
                    break;
                case 3:
                    ihm.supprimerExamen();
                    break;
                case 4:
                    ihm.afficherExamen();
                    break;
                case 5:
                    System.out.println("Retour au menu principal...");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choice != 5);
    }

    public int init(Examen examen) {
        return es.ajouterExamen(examen);
    }

    public int modif(TypeExamen typeExamen, float cout) {
        return es.modifierExamen(typeExamen,cout);
    }

    public int supp(TypeExamen typeExamen) {
        return es.supprimerExamen(typeExamen);
    }

    public List<Examen> affich(){
        return es.afficherExamens();
    }
}