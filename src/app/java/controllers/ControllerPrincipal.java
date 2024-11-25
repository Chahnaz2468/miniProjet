package projet.controllers;

import projet.ihm_principal.MenuPrincipal;
import projet.repository.SalleRepository;
import projet.services.SalleService;

public class ControllerPrincipal {
	
	    SalleController salleController;
	    //private PatientController patientController; 
	    MenuPrincipal menuPrincipal; 

	   
	    public ControllerPrincipal() {
	        this.salleController = new SalleController(new SalleService(new SalleRepository(20)));
	        //this.patientController = new PatientController(new PatientService());
	        this.menuPrincipal = new MenuPrincipal(this); 
	    }

	   
	    public void init() {
	        System.out.println("Welcome to the Radiology Center Management System");
	        menuPrincipal.showMenu();  
	    }

	   
	    public void gestionSalle() {
	        salleController.init(); 
	    }
	
	   /* public void gestionPatient() {
	        patientController.init(); 
	    }
	  }*/

	}

