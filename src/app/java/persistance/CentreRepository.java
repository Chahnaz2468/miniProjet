package persistance;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Centre;

import java.io.File;
import java.io.IOException;

public class CentreRepository {
    static File file = new File("src/app/resources/CentreData.json");
    private Centre centre;

    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }

    public void saveCentre() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(file, centre);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadCentre() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (file.exists()) {
                centre = mapper.readValue(file, Centre.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
