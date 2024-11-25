package projet.ihm_principal;

import java.util.Scanner;

import projet.controllers.ControllerPrincipal;
public class MenuPrincipal {
	    ControllerPrincipal  ControllerPrincipal;

	    
	    public MenuPrincipal(ControllerPrincipal  ControllerPrincipal) {
	        this.ControllerPrincipal = ControllerPrincipal;
	    }

	   
	    public void showMenu() {
	        Scanner scanner = new Scanner(System.in);
	        int choice = 0;
	        do {
	            System.out.println("\nMenu Principal:");
	            System.out.println("1. Gestion des Salles");
	            System.out.println("2. Gestion des Patients");
	            System.out.println("3. Quitter");
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
	                /*case 2:
	                	ControllerPrincipal.gestionPatient(); 
	                    break;*/
	                case 3:
	                    System.out.println("");
	                    
	                    break;
	                default:
	                    System.out.println("Option invalide. Essayez encore.");
	            }
	        } while (choice != 3);
	        
	    }
	}


	

