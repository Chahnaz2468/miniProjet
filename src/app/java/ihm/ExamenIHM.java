package ihm;
import entities.Examen;
import entities.TypeExamen;

import java.util.List;
import java.util.Scanner;
import controllers.ExamenController;

public class ExamenIHM {
    private ExamenController ec;

    public ExamenIHM(ExamenController ec) {
        this.ec = ec;
    }

    public ExamenController getEc() {
        return ec;
    }

    public void setEc(ExamenController ec) {
        this.ec = ec;
    }

    public void saisir() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le type d'examen (Radiographie, Echographie, Mammographie, Doppler, Scanner, IRM): ");
        String input = sc.next();
        TypeExamen typeExamen = null;
        try {
            typeExamen = TypeExamen.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Type d'examen invalide! Veuillez entrer un type correct.");
        }
        System.out.println("Veuillez saisir le cout de l'examen: ");
        float coutExamen = sc.nextFloat();
        System.out.println("Veuillez saisir la duree de l'examen: ");
        int dureeExamen = sc.nextInt();
        Examen ex = new Examen(typeExamen, coutExamen, dureeExamen);
        if (ec.init(ex) ==1)
            System.out.println("Examen ajouté avec succes ");
        else
            System.out.println("Erreur");
    }

    public void modifierCout() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le type d'examen à modifier: ");
        String input = sc.next();
        TypeExamen typeExamen = TypeExamen.valueOf(input);
        System.out.println("Veuillez saisir le nouveau cout de l'examen: ");
        float cout = sc.nextFloat();
        if (ec.modif(typeExamen,cout) ==1)
            System.out.println("Modification faite avec succes ");
        else
            System.out.println("Erreur");
    }

    public void supprimerExamen() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le type d'examen à supprimer: ");
        String input = sc.next();
        TypeExamen typeExamen = TypeExamen.valueOf(input);
        if (ec.supp(typeExamen) ==1)
            System.out.println("Suppresion faite avec succes ");
        else
            System.out.println("Erreur");
    }

    public void afficherExamen() {
        List<Examen> examens=ec.affich();
        if (examens == null || examens.isEmpty()) {
            System.out.println("Aucun examen à afficher.");
            return;
        }

        for (Examen examen : examens) {
            System.out.println("Examen:");
            System.out.println("  Type d'examen: " + examen.getTypeExamen());
            System.out.println("  Coût: " + examen.getCout());
            System.out.println("  Durée: " + examen.getDuree());
            System.out.println("-----------------------------");
        }
    }
}