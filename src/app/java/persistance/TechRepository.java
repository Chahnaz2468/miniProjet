package persistance;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Technicien;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TechRepository {
    static File file = new File("src/app/resources/TechData.json");

    public static int ajouterTech(Technicien tech) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Technicien> techs;
            if (file.exists() && file.length() > 0) {
                techs = mapper.readValue(file, new TypeReference<List<Technicien>>() {});
            } else {
                techs = new ArrayList<>();
            }
            techs.add(tech);
            mapper.writeValue(file, techs);
            return 1;
        } catch (IOException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public static int modifierHorraireTech(int id,int hr) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (!file.exists() || file.length() == 0) {
                return -1;
            }
            List<Technicien> techs = mapper.readValue(file, new TypeReference<List<Technicien>>() {});
            boolean found = false;
            for (Technicien tech : techs) {
                if (tech.getId() == id) {
                    tech.setHorraire(hr);
                    found = true;
                    break;
                }
            }
            if (found) {
                mapper.writeValue(file, techs);
                return 1;
            } else {
                return 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return -2;
        }
    }
    public static int supprimerTech(int id) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (!file.exists() || file.length() == 0) {
                return -1;
            }
            List<Technicien> techs = mapper.readValue(file, new TypeReference<List<Technicien>>() {});
            Iterator<Technicien> iterator = techs.iterator();
            boolean found = false;
            while (iterator.hasNext()) {
                Technicien tech = iterator.next();
                if (tech.getId() == id) {
                    iterator.remove();
                    found = true;
                    break;
                }
            }
            if (found) {
                mapper.writeValue(file, techs);
                return 1;
            } else {
                return 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return -2;
        }
    }

    public static List<Technicien> afficherTechs() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Technicien> techs = mapper.readValue(file, new TypeReference<List<Technicien>>() {});
            return techs;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Technicien findTechById(int id) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (file.exists() && file.length() > 0) {
                List<Technicien> techs = mapper.readValue(file, new TypeReference<List<Technicien>>() {});
                for (Technicien tech : techs) {
                    if (tech.getId() == id) {
                        return tech;
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
