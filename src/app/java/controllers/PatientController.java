package controllers;

import entities.Patient;

import exceptions.PatientRedondanceException;
import ihm.PatientIhm;
import services.PatientService;

public class PatientController {
    PatientService patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    public void init() {
        PatientIhm patientIhm = new PatientIhm(this);
        patientIhm.showPatientMenu();

    }

    public void ajouterPatient(Patient patient) throws PatientRedondanceException {
        patientService.ajouterPatient(patient);
    }

    public Patient[] afficherPatients() {

        return patientService.getPatients();

    }

    public void modifiererPatient(int id, Patient newPatient) {
        patientService.modifierPatient(id,newPatient);
    }

    public void retirerPatient(int id) {
        patientService.retirerPatient(id);
    }

    public Patient trouverPatient(int id) {
        return patientService.getPatient(id);
    }

}
