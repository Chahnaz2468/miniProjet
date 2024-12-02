package persistance;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.DossierMed;
import entities.Ordonnance;
import entities.TypeExamen;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DossierMedRepository {
    static File file = new File("src/app/resources/DossierMedData.json");

    public static int ajouterDossierMed(DossierMed dossierMed) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<DossierMed> dossierMeds;
            if (file.exists() && file.length() > 0) {
                dossierMeds = mapper.readValue(file, new TypeReference<List<DossierMed>>() {});
            } else {
                dossierMeds = new ArrayList<>();
            }
            dossierMeds.add(dossierMed);
            mapper.writeValue(file, dossierMeds);
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int modifierTypeExLastOrd(int id,TypeExamen typeExamen) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (!file.exists() || file.length() == 0) {
                return -1;
            }

            List<DossierMed> dossierMeds = mapper.readValue(file, new TypeReference<List<DossierMed>>() {});
            boolean found = false;

            for (DossierMed dossierMed : dossierMeds) {
                if (dossierMed.getId() == id) {
                    if (dossierMed.getOrds().isEmpty()) {
                        return -2;
                    }
                    Ordonnance lastItem = dossierMed.getOrds().getLast();
                    lastItem.setTypeExamen(typeExamen);
                    found = true;
                    break;
                }
            }

            if (found) {
                mapper.writeValue(file, dossierMeds);
                return 1;
            } else {
                return 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return -3;
        }
    }

    public static int supprimerDossierMed(int id) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (!file.exists() || file.length() == 0) {
                return -1;
            }
            List<DossierMed> dossierMeds = mapper.readValue(file, new TypeReference<List<DossierMed>>() {});
            Iterator<DossierMed> iterator = dossierMeds.iterator();
            boolean found = false;

            while (iterator.hasNext()) {
                DossierMed dossierMed = iterator.next();
                if (dossierMed.getId() == id) {
                    iterator.remove();
                    found = true;
                }
            }
            if (found) {
                mapper.writeValue(file, dossierMeds);
                return 1;
            } else {
                return 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return -2;
        }
    }

    public static List<DossierMed> afficherDossierMeds() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (!file.exists() || file.length() == 0) {
                return new ArrayList<>();
            }
            return mapper.readValue(file, new TypeReference<List<DossierMed>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static DossierMed findDossierMedByPatientId(int id) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (file.exists() && file.length() > 0) {
                List<DossierMed> dossierMeds = mapper.readValue(file, new TypeReference<List<DossierMed>>() {});
                for (DossierMed dossierMed : dossierMeds) {
                    if (dossierMed.getPatient().getId() == id) {
                        return dossierMed;
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
