package app.java.controllers;

import app.java.entities.Patient;

import app.java.exceptions.PatientRedondanceException;
import app.java.ihm.PatientIhm;
import app.java.services.PatientService;

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
    public void modifiererPatient(double id, Patient newPatient) {
        patientService.modifierPatient(id,newPatient);
    }
    public void retirerPatient(double id) {
        patientService.retirerPatient(id);
    }


}
