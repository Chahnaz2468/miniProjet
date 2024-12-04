package controllers;
import entities.TypeExamen;
import services.SalleService;
import entities.Salle;
import ihm.SalleIhm;
import exceptions.SalleNonDisponibleException;
import exceptions.DoubleSalleException;

import java.time.LocalDateTime;

public class SalleController {
	   SalleService salleService=new SalleService();

	   public SalleController() {}

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

	public boolean verifierSalleDisponibiliteParTemps(TypeExamen typeExamen, LocalDateTime debut, LocalDateTime fin) {
		return salleService.verifierSalleDisponibiliteParTemps(typeExamen, debut, fin);
	}

	public Salle findSalleByType(TypeExamen typeExamen) {
		   return salleService.findSalleByType(typeExamen);
	}
}
