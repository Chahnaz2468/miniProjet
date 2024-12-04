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
				System.out.println("1. Gestion du centre");
	            System.out.println("2. Gestion des salles");
				System.out.println("3. Gestion des examens");
				System.out.println("4. Gestion des medecins prescripteurs");
				System.out.println("5. Gestion des medecins radiologues");
				System.out.println("6. Gestion des techniciens");
	            System.out.println("7. Gestion des patients");
				System.out.println("8. Gestion des dossiers medicaux");
				System.out.println("9. Gestion des rendez vous");
				System.out.println("10. Gestion des compte-rendus");
				System.out.println("11. Gestion des finances");
	            System.out.println("12. Quitter");
	            System.out.print("Choisissez une option: ");
	            if (scanner.hasNextInt()) {
	                choice = scanner.nextInt();
	            } else {
	                System.out.println("Entrée invalide. Veuillez entrer un entier.");
	                scanner.next();  
	            }

	            switch (choice) {
					case 1:
						ControllerPrincipal.gestionCentre();
					case 2:
	                	ControllerPrincipal.gestionSalle(); 
	                    break;
					case 3:
						ControllerPrincipal.gestionExamens();
						break;
					case 4:
	                	ControllerPrincipal.gestionMedPrescris();
	                    break;
					case 5:
						ControllerPrincipal.gestionMedRadios();
						break;
					case 6:
						ControllerPrincipal.gestionTech();
						break;
	                case 7:
						ControllerPrincipal.gestionPatient();
	                    break;
					case 8:
						ControllerPrincipal.gestionDossierMed();
						break;
					case 9:
						ControllerPrincipal.gestionRendezVous();
						break;
					case 10:
						ControllerPrincipal.gestionCompteRendu();
						break;
					case 11:
						ControllerPrincipal.gestionFinance();
						break;
					case 12:
						System.out.println("");
						break;
	                default:
	                    System.out.println("Option invalide. Essayez encore.");
	            }
	        } while (choice != 12);
	    }
	}


	

