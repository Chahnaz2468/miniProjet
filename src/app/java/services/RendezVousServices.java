package services;

import entities.RendezVous;
import persistance.RendezVousRepository;

import java.time.LocalDateTime;
import java.util.List;

public class RendezVousServices {
    public int ajouterRendezVous(RendezVous rendezVous) {
        return RendezVousRepository.ajouterRendezVous(rendezVous);
    }

    public int modifierDateRendezVous(int id, LocalDateTime date) {
        return RendezVousRepository.modifierDateRendezVous(id,date);
    }

    public int supprimerRendezVous(int id) {
        return RendezVousRepository.supprimerRendezVous(id);
    }

    public List<RendezVous> afficherRendezVouss (){
        List<RendezVous> rendezVouss = RendezVousRepository.afficherRendezVouss();
        if (rendezVouss == null) {
            throw new RuntimeException("Erreur lors de la récupération des rendez vous.");
        }
        return rendezVouss;
    }

    public RendezVous findRendezVousById(int id) {
        RendezVous rendezVous = RendezVousRepository.findRendezVousById(id);
        if (rendezVous == null) {
            throw new IllegalArgumentException("Aucun rendez vous trouvé pour l'ID: " + id);
        }
        return rendezVous;
    }
}
