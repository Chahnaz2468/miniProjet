package controllers;
import services.SalleService;
import entities.Salle;
import ihm.SalleIhm;
import exceptions.SalleNonDisponibleException;
import exceptions.DoubleSalleException;

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
