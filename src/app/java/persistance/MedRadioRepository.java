package persistance;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.MedRadio;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MedRadioRepository {
    static File file = new File("src/app/resources/MedRadioData.json");

    public static int ajouterMedRadio(MedRadio medRadio) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<MedRadio> medRadios;
            if (file.exists() && file.length() > 0) {
                medRadios = mapper.readValue(file, new TypeReference<List<MedRadio>>() {});
            } else {
                medRadios = new ArrayList<>();
            }
            medRadios.add(medRadio);
            mapper.writeValue(file, medRadios);
            return 1;
        } catch (IOException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public static int modifierHorraireMedRadio(int id,int hr) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<MedRadio> medRadios = mapper.readValue(file,new TypeReference<List<MedRadio>>() {});

            for (MedRadio medRadio : medRadios) {
                if (medRadio.getId()==id) {
                    medRadio.setHorraire(hr);
                }
            }
            mapper.writeValue(file, medRadios);
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int supprimerMedRadio(int id) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<MedRadio> medRadios = mapper.readValue(file,new TypeReference<List<MedRadio>>() {});
            Iterator<MedRadio> iterator = medRadios.iterator();
            while (iterator.hasNext()) {
                MedRadio medRadio = iterator.next();
                if (medRadio.getId()==id) {
                    iterator.remove();
                }
                mapper.writeValue(file, medRadios);
                return 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return 0;
    }

    public static List<MedRadio> afficherMedRadios() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<MedRadio> medRadios = mapper.readValue(file, new TypeReference<List<MedRadio>>() {});
            return medRadios;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static MedRadio findMedRadioById(int id) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (file.exists() && file.length() > 0) {
                List<MedRadio> medRadios = mapper.readValue(file, new TypeReference<List<MedRadio>>() {});
                for (MedRadio medRadio : medRadios) {
                    if (medRadio.getId() == id) {
                        return medRadio;
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
