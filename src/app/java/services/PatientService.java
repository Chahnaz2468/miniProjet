package app.java.services;

import app.java.entities.Patient;

import app.java.exceptions. PatientRedondanceException;
import app.java.persistance.PatientRepository;

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
    public void modifierPatient(double id, Patient newPatient) {
        if (id >0 && id < patientRepository.getPatients().length) {
            patientRepository.getPatients()[(int) id] = newPatient;
            patientRepository.savePatients();
        }
    }

    public void retirerPatient(double id){
        if (id >0 && id < patientRepository.getPatients().length) {
            patientRepository.getPatients()[(int) id] = null;
            patientRepository.savePatients();
        }
    }



    public Patient[] getPatients() {
        return patientRepository.getPatients();
    }
}
