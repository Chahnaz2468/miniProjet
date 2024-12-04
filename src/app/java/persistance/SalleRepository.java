package persistance;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Salle;
import java.io.File;
import java.io.IOException;

public class SalleRepository {
    static File file = new File("src/app/resources/SalleData.json");
    private Salle[] salles = new Salle[100];

    public SalleRepository() {
        loadSalles();
        if (salles == null) this.salles = new Salle[100];
    }

    public Salle[] getSalles() {
        return salles;
    }

    public void setSalles(Salle[] salles) {
        this.salles = salles;
    }

    public void saveSalles() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(file, salles);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde des salles: " + e.getMessage());
        }
    }

    public void loadSalles() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (file.exists()) {
                salles = mapper.readValue(file, new TypeReference<Salle[]>() {});
            }
        } catch (IOException e) {}
    }}

    
