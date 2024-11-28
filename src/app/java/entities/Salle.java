package entities;


public class Salle {
	 private int num;
	 private TypeExamen typeExamen;
	 private boolean disponibilite;
	 public Salle(int num, TypeExamen typeExamen, boolean disponibilite) {
		this.num = num;
		this.typeExamen = typeExamen;
		this.disponibilite = disponibilite;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public TypeExamen getTypeExamen() {
		return typeExamen;
	}
	public void setTypeExamen(TypeExamen typeExamen) {
		this.typeExamen = typeExamen;
	}
	public boolean getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}

     
	 
}
