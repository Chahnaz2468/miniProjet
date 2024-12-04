package services;
import entities.RendezVous;
import entities.Salle;
import entities.TypeExamen;
import exceptions.DoubleSalleException;
import exceptions.SalleNonDisponibleException;
import persistance.RendezVousRepository;
import persistance.SalleRepository;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.List;

public class SalleService {
	SalleRepository salleRepository=new SalleRepository();

	public SalleService() {}

    public SalleService(SalleRepository salleRepository) {
		
		this.salleRepository =salleRepository;
	}


	public void ajouterSalle(Salle salle) throws DoubleSalleException {
		Salle[] salles = salleRepository.getSalles();
		for (Salle s : salles) {
			if (s != null && s.getNum() == salle.getNum()) {
				throw new DoubleSalleException("Salle avec le numéro " + salle.getNum() + " existe déjà.");
			}
		}
		for (int i = 0; i < salles.length; i++) {
			if (salles[i] == null) {
				salles[i] = salle;
				salleRepository.saveSalles();
				return;
			}
		}
		throw new IllegalStateException("Impossible d'ajouter la salle, toutes les places sont occupées.");
	}
	public void modifierSalle(int num, Salle newSalle) {
		Salle[] salles = salleRepository.getSalles();
		for (int i = 0; i < salles.length; i++) {
			if (salles[i] != null && salles[i].getNum() == num) {
				salles[i] = newSalle;
				salleRepository.saveSalles();
				return;
			}
		}
		throw new IllegalArgumentException("Salle non trouvée.");
	}

	public void retirerSalle(int num){
		Salle[] salles = salleRepository.getSalles();
		for (int i = 0; i < salles.length; i++) {
			if (salles[i] != null && salles[i].getNum() == num) {
				salles[i] = null;
				salleRepository.saveSalles();
				return;
			}
		}
		throw new IllegalArgumentException("Salle non trouvée.");
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

	public boolean verifierSalleDisponibiliteParTemps(TypeExamen TypeEx, LocalDateTime debut, LocalDateTime fin) {
		Salle[] salles = salleRepository.getSalles();
		for (Salle salle : salles) {
			if (salle != null && salle.getTypeExamen() == TypeEx) {
				if (!salle.getDisponibilite()) {
					return false;
				}
				List<RendezVous> rendezVouss = RendezVousRepository.afficherRendezVouss();
				for (RendezVous rendezVous : rendezVouss) {
					if (rendezVous.getSalle().getTypeExamen() == TypeEx &&
							rendezVous.getDate().isBefore(fin) && rendezVous.getDate().plusHours(1).isAfter(debut)) {
						return false;
					}
				}
				return true;
			}
		}
		throw new IllegalArgumentException("Salle numéro " + TypeEx + " n'existe pas.");
	}

	public Salle findSalleByType(TypeExamen typeExamen) {
		Salle[] salles = salleRepository.getSalles();
		for (Salle salle : salles) {
			if (salle.getTypeExamen() == typeExamen) {
				return salle;
			}
		}
		return null;
	}
}
