package controllers;

import ihm.MenuPrincipal;
import persistance.SalleRepository;
import services.SalleService;

public class ControllerPrincipal {
	
	    SalleController salleController;
	    MenuPrincipal menuPrincipal; 

	    public ControllerPrincipal() {
	        this.salleController = new SalleController(new SalleService(new SalleRepository(20)));
	        this.menuPrincipal = new MenuPrincipal(this); 
	    }

	    public void init() {
	        System.out.println("Welcome to the Radiology Center Management System");
	        menuPrincipal.showMenu();  
	    }

	    public void gestionSalle() {
	        salleController.init(); 
	    }
	}

