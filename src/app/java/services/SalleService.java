package projet.services;


import projet.entities.Salle;
import projet.exceptions.DoubleSalleException;
import projet.exceptions.SalleNonDisponibleException;
import projet.repository.SalleRepository;

public class SalleService {
	SalleRepository salleRepository;
    public SalleService(SalleRepository salleRepository) {
		
		this.salleRepository =salleRepository;
	}

	public void ajouterSalle(Salle salle) throws DoubleSalleException {
        Salle[] salles = salleRepository.getSalles();
        for (int i = 0; i < salles.length; i++) {
            if (salles[i] != null && salles[i].getNum() == salle.getNum()) {
                throw new DoubleSalleException("Salle with number " + salle.getNum() + " already exists.");
            }
            if (salles[i] == null) {
                salles[i] = salle;
                salleRepository.saveSalles();
                return;
            }
        }
        System.out.println("No space available to add a new room."); 
	}

	public boolean verifierSalleDisponibilite(int num) throws SalleNonDisponibleException {
	    Salle[] salles = salleRepository.getSalles();
	    boolean salleTrouvee = true;

	    for (Salle salle : salles) {
	        
	    	if (salle == null || salle.getNum() != num) {
	    	    continue;
	    	}
	    	if (!salle.getDisponibilite()) {
	    		salleTrouvee = false;
	    	    throw new SalleNonDisponibleException("Room " + num + " is not available.");
	    	}
	    }
		return salleTrouvee; 

	     }
	public void afficherSalles() {
	    Salle[] salles = salleRepository.getSalles();
	    if (salles == null || salles.length == 0) {
	        System.out.println("Aucune salle disponible.");
	        return;
	    }

	    boolean hasSalle = false;
	    for (Salle salle : salles) {
	        if (salle != null) {
	            System.out.printf("Salle numéro: %d, Type: %s, Disponibilité: %b\n",
	                salle.getNum(), salle.getTypeExamen(), salle.getDisponibilite());
	            hasSalle = true;
	        }
	    }

	    if (!hasSalle) {
	        System.out.println("Aucune salle n'est actuellement ajoutée.");
	    }
	}


	    
	


	 
}
