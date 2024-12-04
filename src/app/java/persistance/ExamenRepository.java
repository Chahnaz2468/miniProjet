package persistance;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Examen;
import entities.TypeExamen;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExamenRepository {
    static File file = new File("src/app/resources/ExamenData.json");

    public static int ajouterExamen(Examen examen) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Examen> examens;
            if (file.exists() && file.length() > 0) {
                examens = mapper.readValue(file, new TypeReference<List<Examen>>() {});
            } else {
                examens = new ArrayList<>();
            }
            examens.add(examen);
            mapper.writeValue(file, examens);
            return 1;
        } catch (IOException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public static int modifierCoutExamen(TypeExamen typeExamen, float cout) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Examen> examens = mapper.readValue(file,new TypeReference<List<Examen>>() {});

            for (Examen examen : examens) {
                if (examen.getTypeExamen().equals(typeExamen)) {
                    examen.setCout(cout);
                }
            }
            mapper.writeValue(file, examens);
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int supprimerExamen(TypeExamen typeExamen) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Examen> examens = mapper.readValue(file, new TypeReference<List<Examen>>() {});
            boolean found = false;
            Iterator<Examen> iterator = examens.iterator();
            while (iterator.hasNext()) {
                Examen examen = iterator.next();
                if (examen.getTypeExamen().equals(typeExamen)) {
                    iterator.remove();
                    found = true;
                }
            }
            if (found) {
                mapper.writeValue(file, examens);
                return 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return 0;
    }

    public static List<Examen> afficherExamens() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Examen> examens = mapper.readValue(file, new TypeReference<List<Examen>>() {});
            return examens;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static Examen trouverExamenParType(TypeExamen typeExamen) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (file.exists() && file.length() > 0) {
                List<Examen> examens = mapper.readValue(file, new TypeReference<List<Examen>>() {});
                if (examens != null && !examens.isEmpty()) {
                    for (Examen examen : examens) {
                        if (examen.getTypeExamen().equals(typeExamen)) {
                            return examen;
                        }
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
