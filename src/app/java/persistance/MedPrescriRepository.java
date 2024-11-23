package persistance;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.MedPrescri;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class MedPrescriRepository {
    public static void ajouterMedPriscri(MedPrescri medPrescri) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("MedPrescriData.json"), medPrescri);
            System.out.println("Medecin prescripteur ajouté avec succes ");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void modifierTelephoneMedPrescri(double id, double telephone) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<MedPrescri> medPrescris = mapper.readValue(new File("MedPrescriData.json"), List.class);
            for (MedPrescri medPrescri : medPrescris) {
                if (medPrescri.getId()==id) {
                    medPrescri.setTelephone(telephone);
                }
            }
            mapper.writeValue(new File("ExamenData.json"), medPrescris);
            System.out.println("Modification faite avec succes ");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void supprimerMedPrescri(double id) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<MedPrescri> medPrescris = mapper.readValue(new File("MedPrescriData.json"), List.class);
            Iterator<MedPrescri> iterator = medPrescris.iterator();
            while (iterator.hasNext()) {
                MedPrescri medPrescri = iterator.next();
                if (medPrescri.getId()==(id)) {
                    iterator.remove();
                }
                mapper.writeValue(new File("ExamenData.json"), medPrescris);
                System.out.println("Suppresion faite avec succes ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
