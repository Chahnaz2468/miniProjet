package examens.persistance;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import examens.entities.Examen;
import examens.entities.TypeExamen;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ExamenRepository {
    public static void ajouterExamen(Examen examen) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("ExamenData.json"), examen);
            System.out.println("Examen avec succes ");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void modifierCoutExamen(TypeExamen typeExamen, float cout) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Examen> examens = mapper.readValue(new File("ExamenData.json"), List.class);
            for (Examen examen : examens) {
                if (examen.getTypeExamen().equals("typeExamen")) {
                    examen.setCout(cout);
                }
            }
            mapper.writeValue(new File("ExamenData.json"), examens);
            System.out.println("Modification faite avec succes ");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void supprimerExamen(TypeExamen typeExamen) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Examen> examens = mapper.readValue(new File("ExamenData.json"), List.class);
            Iterator<Examen> iterator = examens.iterator();
            while (iterator.hasNext()) {
                Examen examen = iterator.next();
                if (examen.getTypeExamen().equals(typeExamen)) {
                    iterator.remove();
                }
                mapper.writeValue(new File("ExamenData.json"), examens);
                System.out.println("Suppresion faite avec succes ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
