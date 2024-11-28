package app.java.persistance;


import app.java.entities.Patient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class PatientRepository {
    private static final String FILE_PATH = "patients.json";
    private Patient[] patients;

    public PatientRepository() {
        loadPatients();
        if (patients == null) this.patients = new Patient[100];
    }

    public Patient[] getPatients() {
        return patients;
    }

    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }

    public void savePatients() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(FILE_PATH), patients);
        } catch (IOException e) {

        }
    }

    public void loadPatients() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                patients = mapper.readValue(file, new TypeReference<Patient[]>() {});
            }
        } catch (IOException e) {}
    }}




