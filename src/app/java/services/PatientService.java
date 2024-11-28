package services;

import entities.Patient;

import exceptions. PatientRedondanceException;
import persistance.PatientRepository;

public class PatientService {
    PatientRepository patientRepository;
    public PatientService(PatientRepository patientRepository) {

        this.patientRepository =patientRepository;
    }


    public void ajouterPatient(Patient patient) throws PatientRedondanceException {
        Patient[] patients = patientRepository.getPatients();
        for (Patient p : patients) {
            if (p != null && p.getId() == patient.getId())
                throw new PatientRedondanceException("le patient avec l'id " + patient.getId() + " existe déja.");
        }
        patientRepository.savePatients();
    }
    public void modifierPatient(int id, Patient newPatient) {
        if (id >0 && id < patientRepository.getPatients().length) {
            patientRepository.getPatients()[id] = newPatient;
            patientRepository.savePatients();
        }
    }

    public void retirerPatient(int id){
        if (id >0 && id < patientRepository.getPatients().length) {
            patientRepository.getPatients()[id] = null;
            patientRepository.savePatients();
        }
    }



    public Patient[] getPatients() {
        return patientRepository.getPatients();
    }
}
