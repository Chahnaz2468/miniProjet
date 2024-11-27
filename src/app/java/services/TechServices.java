package services;

import entities.Technicien;
import persistance.TechRepository;

import java.util.List;

public class TechServices {
    public int ajouterTech(Technicien tech) {
        return TechRepository.ajouterTech(tech);
    }

    public int modifierTech(int id, int hr) {
        return TechRepository.modifierHorraireTech(id,hr);
    }

    public int supprimerTech(int id) {
        return TechRepository.supprimerTech(id);
    }

    public List<Technicien> afficherTechs (){
        return TechRepository.afficherTechs();
    }

    public Technicien findTechById(int id) {
        return TechRepository.findTechById(id);
    }
}
