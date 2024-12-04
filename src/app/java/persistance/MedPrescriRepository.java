package persistance;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.MedPrescri;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MedPrescriRepository {
    static File file = new File("src/app/resources/MedPrescriData.json");

    public static int ajouterMedPriscri(MedPrescri medPrescri) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<MedPrescri> medPrescris;
            if (file.exists() && file.length() > 0) {
                medPrescris = mapper.readValue(file, List.class);
            } else {
                medPrescris = new ArrayList<>();
            }
            medPrescris.add(medPrescri);
            mapper.writeValue(file, medPrescris);
            return 1;
        } catch (IOException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public static int modifierTelephoneMedPrescri(int id, String telephone) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (!file.exists() || file.length() == 0) {
                return -1;
            }
            List<MedPrescri> medPrescris = mapper.readValue(file, new TypeReference<List<MedPrescri>>() {});
            boolean found = false;

            for (MedPrescri medPrescri : medPrescris) {
                if (medPrescri.getId() == id) {
                    medPrescri.setTelephone(telephone);
                    found = true;
                    break;
                }
            }

            if (found) {
                mapper.writeValue(file, medPrescris);
                return 1;
            } else {
                return 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return -2;
        }
    }

    public static int supprimerMedPrescri(int id) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (!file.exists() || file.length() == 0) {
                return -1;
            }
            List<MedPrescri> medPrescris = mapper.readValue(file, new TypeReference<List<MedPrescri>>() {});
            Iterator<MedPrescri> iterator = medPrescris.iterator();
            boolean found = false;
            while (iterator.hasNext()) {
                MedPrescri medPrescri = iterator.next();
                if (medPrescri.getId() == id) {
                    iterator.remove();
                    found = true;
                }
            }
            if (found) {
                mapper.writeValue(file, medPrescris);
                return 1;
            } else {
                return 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return -2;
        }
    }

    public static List<MedPrescri> afficherMedPrescris() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (!file.exists() || file.length() == 0) {
                return new ArrayList<>();
            }
            return mapper.readValue(file, new TypeReference<List<MedPrescri>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static MedPrescri findMedPrescriById(int id) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (file.exists() && file.length() > 0) {
                List<MedPrescri> medPrescris = mapper.readValue(file, new TypeReference<List<MedPrescri>>() {});
                for (MedPrescri medPrescri : medPrescris) {
                    if (medPrescri.getId() == id) {
                        return medPrescri;
                    }
                }
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
