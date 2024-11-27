package entities;

public class Examen {
    private TypeExamen typeExamen;
    private float cout;
    private int duree;

    public Examen() {
    }

    public Examen(TypeExamen typeExamen, float cout, int duree) {
        this.typeExamen = typeExamen;
        this.cout = cout;
        this.duree = duree;
    }

    public TypeExamen getTypeExamen() {
        return typeExamen;
    }

    public void setTypeExamen(TypeExamen typeExamen) {
        this.typeExamen = typeExamen;
    }

    public float getCout() {
        return cout;
    }

    public void setCout(float cout) {
        this.cout = cout;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
}
