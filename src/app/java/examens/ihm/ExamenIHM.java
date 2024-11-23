package examens.ihm;
import examens.entities.Examen;
import examens.entities.TypeExamen;
import java.util.Scanner;

public class ExamenIHM {
    public static void saisir(Examen ex) {
        Scanner sc = new Scanner(System.in);
        TypeExamen typeExamen = null;
        while (typeExamen == null) {
            System.out.println("Veuillez saisir le type d'examen (Radiographie, Echographie, Mammographie, Doppler, Scanner, IRM) :");
            String input = sc.next();
            try {
                typeExamen = TypeExamen.valueOf(input);
                ex.setTypeExamen(typeExamen);
            } catch (IllegalArgumentException e) {
                System.out.println("Type d'examen invalide! Veuillez entrer un type correct.");
            }
        }
        System.out.println("Veuillez saisir le cout de l'examen");
        float coutExamen = sc.nextFloat();
        ex.setCout(coutExamen);
        System.out.println("Veuillez saisir la duree de l'examen");
        int dureeExamen = sc.nextInt();
        ex.setDuree(dureeExamen);
    }

    public static void modifierCout(TypeExamen typeExamen, float cout) {
        System.out.println("Veuillez saisir le type d'examen à modifier: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        typeExamen = TypeExamen.valueOf(input);
        System.out.println("Veuillez saisir le nouveau cout de l'examen");
        cout = sc.nextFloat();
    }

    public static TypeExamen supprimerExamen() {
        System.out.println("Veuillez saisir le type d'examen à supprimer: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        return TypeExamen.valueOf(input);
    }
}



