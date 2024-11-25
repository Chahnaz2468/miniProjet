package projet.controllers;

import projet.entities.Salle;
import projet.exceptions.SalleNonDisponibleException;
import projet.ihm_salle.SalleIhm;
import projet.services.SalleService;

public class SalleController {
	   SalleService salleService;
       public SalleController(SalleService salleService) {
	    	this.salleService = salleService;
	   }
       public void init() {
    	   SalleIhm salleIhm = new SalleIhm(this); 
           salleIhm.showSalleMenu();
           
	    }

	  
       public void ajouterSalle(Salle salle) {
    	    try {
    	        
    	        salleService.ajouterSalle(salle);
    	        System.out.println("Salle ajoutée avec succès !");
    	    } catch (Exception e) {
    	        System.err.println("Erreur lors de l'ajout de la salle: " + e.getMessage());
    	    }
    	}
	   
	    public void afficherSalles() {
	        salleService.afficherSalles();
	    }

	   
	    public void verifierSalleDisponibilite(int numero) {
	        try {
	            boolean disponible = salleService.verifierSalleDisponibilite(numero);
	            if (disponible) {
	                System.out.println("La salle " + numero + " est disponible.");
	            } else {
	                System.out.println("La salle " + numero + " n'est pas disponible.");
	            }
	        } catch (SalleNonDisponibleException e) {
	            System.err.println("Erreur: " + e.getMessage());
	        }
	    }


}
