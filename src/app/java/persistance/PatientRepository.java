package persistance;


import entities.Patient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PatientRepository {
    static File file = new File("src/app/resources/PatientData.json");
    private List<Patient> patients;

    public PatientRepository() {
        this.patients = new ArrayList<>();
        loadPatients();
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public void savePatients() throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(file, patients);
        } catch (IOException e) {

        }
    }

    public void loadPatients() {
        /*ObjectMapper mapper = new ObjectMapper();
        try {
            if (file.exists()) {
                patients = mapper.readValue(file, new TypeReference<Patient[]>() {});
            }
        } catch (IOException e) {}*/
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (file.exists() && file.length() > 0) {
                patients = mapper.readValue(file, new TypeReference<List<Patient>>() {});
            } else {
                patients = new ArrayList<>();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de l'extraction du patient du fichier", e);
        }
    }
}




