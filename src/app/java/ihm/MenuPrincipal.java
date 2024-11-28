package ihm;
import java.util.Scanner;
import controllers.ControllerPrincipal;

public class MenuPrincipal {
	    ControllerPrincipal  ControllerPrincipal;

	    public MenuPrincipal(ControllerPrincipal  ControllerPrincipal) {
	        this.ControllerPrincipal = ControllerPrincipal;
	    }

	    public void showMenu() {
	        Scanner scanner = new Scanner(System.in);
	        int choice = 0;
			System.out.println("Bienvenue dans le Système de Gestion du Centre de Radiologie");
	        do {
	            System.out.println("\nMenu Principal:");
	            System.out.println("1. Gestion des Salles");
				System.out.println("2. Gestion des Examens");
				System.out.println("3. Gestion des medecins prescripteurs");
				System.out.println("4. Gestion des medecins radiologues");
				System.out.println("5. Gestion des techniciens");
	            System.out.println("6. Gestion des Patients");
	            System.out.println("7. Quitter");
	            System.out.print("Choisissez une option: ");
	            if (scanner.hasNextInt()) {
	                choice = scanner.nextInt();
	            } else {
	                System.out.println("Entrée invalide. Veuillez entrer un entier.");
	                scanner.next();  
	            }

	            switch (choice) {
	                case 1:
	                	ControllerPrincipal.gestionSalle(); 
	                    break;
					case 2:
						ControllerPrincipal.gestionExamens();
						break;
					case 3:
	                	ControllerPrincipal.gestionMedPrescris();
	                    break;
					case 4:
						ControllerPrincipal.gestionMedRadios();
						break;
					case 5:
						ControllerPrincipal.gestionTech();
	                case 6:
						ControllerPrincipal.gestionPatient();
	                    break;
					case 7:
						System.out.println("");
						break;
	                default:
	                    System.out.println("Option invalide. Essayez encore.");
	            }
	        } while (choice != 7);
	        
	    }
	}


	

