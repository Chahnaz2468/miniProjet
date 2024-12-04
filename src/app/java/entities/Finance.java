package entities;

public class Finance {
    private double depense;
    private double revenu;
    private String description;
    private double total;

    public Finance() {
    }

    public Finance( String description,double revenu) {
        this.revenu = revenu;
        this.description = description;
    }

    public Finance(double depense, String description) {
        this.depense = depense;
        this.description = description;
    }

    public Finance(double depense, double revenu, String description) {
        this.depense = depense;
        this.revenu = revenu;
        this.description = description;
    }

    public double getDepense() {
        return depense;
    }

    public void setDepense(double depense) {
        this.depense = depense;
    }

    public double getRevenu() {
        return revenu;
    }

    public void setRevenu(double revenu) {
        this.revenu = revenu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
