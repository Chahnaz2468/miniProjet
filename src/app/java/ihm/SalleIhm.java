package ihm;
import entities.Salle;
import entities.TypeExamen;
import java.util.Scanner;
import controllers.SalleController;

public class SalleIhm {
	SalleController salleController;
    
    public SalleIhm(SalleController salleController) {
		this.salleController = salleController;
	}

	public static Salle saisirSalle() {
		Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le numéro de la salle:");
        int num = sc.nextInt();
        System.out.println("la salle est-elle disponible? (true/false):");
        boolean disponibilite = sc.nextBoolean();
        sc.nextLine(); 
        System.out.println("Choisir le type d'examen:");
        for (TypeExamen type : TypeExamen.values()) {
            System.out.println("- " + type);
        }
        String typeInput = sc.nextLine().toLowerCase();
        TypeExamen typeExamen = TypeExamen.valueOf(typeInput);
        
        return new Salle(num,typeExamen,disponibilite);
        }

    public void showSalleMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("\n===== Menu Gestion des Salles =====");
            System.out.println("1. Ajouter une Salle");
            System.out.println("2. Afficher les Salles");
            System.out.println("3. Retour au Menu Principal");
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
                    Salle s=saisirSalle();
                    salleController.ajouterSalle(s);
                    break;
                case 2:
                    salleController.afficherSalles();
                    break;
                case 3:
                    System.out.println("Retour au menu principal...");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choice != 3);
       
    }
    }

    



