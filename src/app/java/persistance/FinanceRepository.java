package persistance;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Finance;
import entities.Technicien;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FinanceRepository {
    static File file = new File("src/app/resources/FinanceData.json");

    public static int ajouterMontant(Finance finance) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Finance> finances;
            if (file.exists() && file.length() > 0) {
                finances = mapper.readValue(file, new TypeReference<List<Finance>>() {});
            } else {
                finances = new ArrayList<>();
            }
            finances.add(finance);
            mapper.writeValue(file, finances);
            return 1;
        } catch (IOException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public static List<Finance> afficherdepenses() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Finance> finances = new ArrayList<>();
            List<Finance> finances1 = mapper.readValue(file, new TypeReference<List<Finance>>() {});
            for (Finance finance : finances1) {
                if(finance.getRevenu()==0){
                    finances.add(finance);
                }
            }
            return finances;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static double afficherTotalDepense(){
        ObjectMapper mapper = new ObjectMapper();
        double depense=0;
        try {
            List<Finance> finances = mapper.readValue(file, new TypeReference<List<Finance>>() {});
            for (Finance finance : finances) {
                depense+=finance.getDepense();
            }
            return depense;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static double afficherTotalRevenu(){
        ObjectMapper mapper = new ObjectMapper();
        double revenu =0;
        try {
            List<Finance> finances = mapper.readValue(file, new TypeReference<List<Finance>>() {});
            for (Finance finance : finances) {
                revenu +=finance.getRevenu();
            }
            return revenu;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
