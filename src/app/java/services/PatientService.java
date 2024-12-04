package services;

import entities.Patient;

import exceptions. PatientRedondanceException;
import persistance.PatientRepository;

import java.io.IOException;
import java.util.List;

public class PatientService {
    PatientRepository patientRepository;
    public PatientService(PatientRepository patientRepository) {

        this.patientRepository =patientRepository;
    }


    public void ajouterPatient(Patient patient) throws PatientRedondanceException {
        /*Patient[] patients = patientRepository.getPatients();
        for (Patient p : patients) {
            if (p != null && p.getId() == patient.getId())
                throw new PatientRedondanceException("le patient avec l'id " + patient.getId() + " existe déja.");
        }
        patientRepository.savePatients();*/
        List<Patient> patients = patientRepository.getPatients();
        for (Patient p : patients) {
            if (p != null && p.getId() == patient.getId()) {
                throw new PatientRedondanceException("Le patient avec l'ID " + patient.getId() + " existe déjà.");
            }
        }
        patients.add(patient);
        try {
            patientRepository.savePatients();
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de l'ajout du patient", e);
        }
    }
    public void modifierPatient(int id, Patient newPatient) {
        /*if (id >0 && id < patientRepository.getPatients().length) {
            patientRepository.getPatients()[id] = newPatient;
            patientRepository.savePatients();}*/
        List<Patient> patients = patientRepository.getPatients();
        if (id > 0 && id <= patients.size()) {
            patients.set(id - 1, newPatient);  // Update patient at index id - 1
            try {
                patientRepository.savePatients();
            } catch (IOException e) {
                throw new RuntimeException("Erreur lors de la modification du patient", e);
            }
        }

    }

    public void retirerPatient(int id){
        /*if (id >0 && id < patientRepository.getPatients().length) {
            patientRepository.getPatients()[id] = null;
            patientRepository.savePatients();
        }*/
        List<Patient> patients = patientRepository.getPatients();
        if (id > 0 && id <= patients.size()) {
            patients.remove(id - 1);  // Remove patient at index id - 1
            try {
                patientRepository.savePatients();
            } catch (IOException e) {
                throw new RuntimeException("Erreur lors de la suppresion du patient", e);
            }
        }
    }

    public List<Patient> getPatients() {
        return patientRepository.getPatients();
    }

    public Patient getPatient(int id) {
        return patientRepository.getPatients().get(id);
    }

}
