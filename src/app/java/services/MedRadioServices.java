package services;
import entities.MedRadio;
import persistance.MedRadioRepository;
import java.util.List;

public class MedRadioServices {
    public int ajouterMedRadio(MedRadio medRadio) {
        return MedRadioRepository.ajouterMedRadio(medRadio);
    }

    public int modifierMedRadio(int id, int hr) {
        return MedRadioRepository.modifierHorraireMedRadio(id,hr);
    }

    public int supprimerMedRadio(int id) {
        return MedRadioRepository.supprimerMedRadio(id);
    }

    public List<MedRadio> afficherMedRadios (){
        return MedRadioRepository.afficherMedRadios();
    }

    public MedRadio findMedRadioById(int id) {
        return MedRadioRepository.findMedRadioById(id);
    }
}
