package personnes.enteties;

public class Personnel extends Personne {
    protected int horraire;
    protected int annexp;
    protected String email;

    public Personnel(double id, String nom, String prenom, double telephone, int horaire, int annexp, String email) {
        super(id, nom, prenom, telephone);
        this.horraire = horaire;
        this.annexp = annexp;
        this.email = email;
    }

    public int getHorraire() {
        return horraire;
    }

    public void setHorraire(int horraire) {
        this.horraire = horraire;
    }

    public int getAnnexp() {
        return annexp;
    }

    public void setAnnexp(int annexp) {
        this.annexp = annexp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
