package app.java.controllers;
import app.java.services.SalleService;
import app.java.entities.Salle;
import app.java.ihm.SalleIhm;
import app.java.exceptions.SalleNonDisponibleException;
import app.java.exceptions.DoubleSalleException;

public class SalleController {
	   SalleService salleService;
       public SalleController(SalleService salleService) {

		   this.salleService = salleService;
	   }


	public void init() {
    	   SalleIhm salleIhm = new SalleIhm(this); 
           salleIhm.showSalleMenu();
           
	    }

	public void ajouterSalle(Salle salle) throws DoubleSalleException {
		salleService.ajouterSalle(salle);
	}

	public Salle[] afficherSalles() {

		return salleService.getSalles();

	}
	public void modifiererSalle(int num,Salle newSalle) {
		 salleService.modifierSalle(num,newSalle);
	}
	public void retirerSalle(int num) {
		salleService.retirerSalle(num);
	}

	public boolean verifierSalleDisponibilite(int numero) throws SalleNonDisponibleException {
		return salleService.verifierSalleDisponibilite(numero);
	}


}
