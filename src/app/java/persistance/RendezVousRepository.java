package persistance;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.RendezVous;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RendezVousRepository {
    static File file = new File("src/app/resources/RendezVousData.json");

    public static int ajouterRendezVous(RendezVous rendezVous) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<RendezVous> rendezVouss;
            if (file.exists() && file.length() > 0) {
                rendezVouss = mapper.readValue(file, new TypeReference<List<RendezVous>>() {});
            } else {
                rendezVouss = new ArrayList<>();
            }
            rendezVouss.add(rendezVous);
            mapper.writeValue(file, rendezVouss);
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int modifierDateRendezVous(int id, LocalDateTime date) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (!file.exists() || file.length() == 0) {
                return -1;
            }
            List<RendezVous> rendezVouss = mapper.readValue(file, new TypeReference<List<RendezVous>>() {});
            boolean found = false;

            for (RendezVous rendezVous : rendezVouss) {
                if(rendezVous.getId() == id) {
                    rendezVous.setDate(date);
                }
            }
            mapper.writeValue(file, rendezVouss);
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int supprimerRendezVous(int id) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (!file.exists() || file.length() == 0) {
                return -1;
            }
            List<RendezVous> rendezVouss = mapper.readValue(file, new TypeReference<List<RendezVous>>() {});
            Iterator<RendezVous> iterator = rendezVouss.iterator();
            boolean found = false;

            while (iterator.hasNext()) {
                RendezVous rendezVous = iterator.next();
                if (rendezVous.getId() == id) {
                    iterator.remove();
                    found = true;
                }
            }
            if (found) {
                mapper.writeValue(file, rendezVouss);
                return 1;
            } else {
                return 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return -2;
        }
    }

    public static List<RendezVous> afficherRendezVouss() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (!file.exists() || file.length() == 0) {
                return new ArrayList<>();
            }
            return mapper.readValue(file, new TypeReference<List<RendezVous>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static RendezVous findRendezVousById(int id) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (file.exists() && file.length() > 0) {
                List<RendezVous> rendezvouss = mapper.readValue(file, new TypeReference<List<RendezVous>>() {});
                for (RendezVous rendezVous : rendezvouss) {
                    if (rendezVous.getId() == id) {
                        return rendezVous;
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
