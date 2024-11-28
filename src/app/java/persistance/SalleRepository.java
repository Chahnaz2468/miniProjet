package persistance;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Salle;
import java.io.File;
import java.io.IOException;

public class SalleRepository {
	private static final String FILE_PATH = "salles.json";
    private Salle[] salles = new Salle[100];

    public SalleRepository(int i) {
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
            mapper.writeValue(new File(FILE_PATH), salles);
        } catch (IOException e) {

        }
    }

    public void loadSalles() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                salles = mapper.readValue(file, new TypeReference<Salle[]>() {});
            }
        } catch (IOException e) {}
    }}

    
