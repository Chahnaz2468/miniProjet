package entities;

import controllers.MedPrescriController;

import java.util.Scanner;

public class Ordonnance {
    protected int id;
    protected MedPrescri medPrescri;
    protected TypeExamen typeExamen;

    public Ordonnance() {
    }

    public Ordonnance(int id,MedPrescri medPrescri, TypeExamen typeExamen) {
        this.id = id;
        this.medPrescri = medPrescri;
        this.typeExamen = typeExamen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MedPrescri getMedPrescri() {
        return medPrescri;
    }

    public void setMedPrescri(MedPrescri medPrescri) {
        this.medPrescri = medPrescri;
    }

    public TypeExamen getTypeExamen() {
        return typeExamen;
    }

    public void setTypeExamen(TypeExamen typeExamen) {
        this.typeExamen = typeExamen;
    }

    public void ajouterOrdonnance(int id) {
        MedPrescriController mpc=new MedPrescriController();
        Scanner sc = new Scanner(System.in);
        System.out.println("donner l'identifiant du medecin prescripteur: ");
        int idm = sc.nextInt();
        MedPrescri medPrescri = new MedPrescri();
        if (mpc.find(idm)==null) {
            mpc.ajout(medPrescri);
        }else
            medPrescri = mpc.find(idm);
        System.out.println("Veuillez saisir le type d'examen precri (RADIOGRAPHIE, ECHOGRAPHIE, MAMMOGRAPHIE, DOPPLER, SCANNER, IRM): ");
        String input = sc.next();
        TypeExamen typeExamen = null;
        try {
            typeExamen = TypeExamen.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Type d'examen invalide! Veuillez entrer un type correct.");
        }
        this.setId(id);
        this.setMedPrescri(medPrescri);
        this.setTypeExamen(typeExamen);
    }

    public void afficherOrdonnance() {
        MedPrescriController mpc=new MedPrescriController();
    }

    public void afficherOrdonnance(Ordonnance ord) {
        System.out.println("Ordonnance");
        System.out.println("  Id: " + ord.getId());
        System.out.println("  medecin prescripteur: ");
        System.out.println("  ID: " + ord.getMedPrescri().getId());
        System.out.println("  nom: " + ord.getMedPrescri().getNom());
        System.out.println("  prenom: " + ord.getMedPrescri().getPrenom());
        System.out.println("  telephone: " + ord.getMedPrescri().getTelephone());
        System.out.println("  Specialite: " + ord.getMedPrescri().getSpecialite());
        System.out.println("-----------------------------");
    }
}
