package services;
import entities.Salle;
import exceptions.DoubleSalleException;
import exceptions.SalleNonDisponibleException;
import persistance.SalleRepository;

public class SalleService {
	SalleRepository salleRepository;
    public SalleService(SalleRepository salleRepository) {
		
		this.salleRepository =salleRepository;
	}


	public void ajouterSalle(Salle salle) throws DoubleSalleException {
		Salle[] salles = salleRepository.getSalles();
		for (Salle s : salles) {
            if (s!=null && s.getNum() == salle.getNum()) {
                throw new DoubleSalleException("Salle avec le numéro " + salle.getNum() + " existe déja.");
            }
		}
		salleRepository.saveSalles();
	}
	public void modifierSalle(int num, Salle newSalle) {
		if (num > 0 && num < salleRepository.getSalles().length) {
			salleRepository.getSalles()[num] = newSalle;
			salleRepository.saveSalles();
		}
	}

	public void retirerSalle(int num){
		if (num > 0 && num < salleRepository.getSalles().length) {
			salleRepository.getSalles()[num] = null;
			salleRepository.saveSalles();
		}
	}

	public boolean verifierSalleDisponibilite(int num) throws SalleNonDisponibleException {
		Salle[] salles = salleRepository.getSalles();
		for (Salle salle : salles) {
			if (salle.getNum() == num) {
				if (!salle.getDisponibilite()) {
					throw new SalleNonDisponibleException("salle  " + num + " est non disponible.");
				}
				return true;
			}
		}
		throw new SalleNonDisponibleException("salle "+ num + "n'existe pas déja.");
	}

	public Salle[] getSalles() {
		return salleRepository.getSalles();
	}



}
