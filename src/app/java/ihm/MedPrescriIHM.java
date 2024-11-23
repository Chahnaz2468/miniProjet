package ihm;
import entities.MedPrescri;
import java.util.Scanner;

public class MedPrescriIHM {
    public static void saisir(MedPrescri medPrescri) {
        Scanner sc = new Scanner(System.in);
        System.out.println("donner l'identifiant: ");
        double id = sc.nextDouble();
        medPrescri.setId(id);
        System.out.println("donner le nom: ");
        String nom= sc.next();
        medPrescri.setNom(nom);
        System.out.println("donner le prenom: ");
        String prenom = sc.next();
        medPrescri.setNom(prenom);
        System.out.println("donner le numero telephone: ");
        double num = sc.nextDouble();
        medPrescri.setTelephone(num);
        System.out.println("donner la specialite: ");
        String spe = sc.next();
        medPrescri.setSpecialite(spe);
    }

    public static void modifierTelphoneMedPrescri(double id,double telephone){
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir l'id de medecin prescripteur: ");
        id = sc.nextDouble();
        System.out.println("Veuillez saisir le nouveau numero telephone: ");
        telephone = sc.nextDouble();
    }

    public static double supprimerMedPrescri(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir l'id de medecin prescripteur à supprimer: ");
        double input = sc.nextDouble();
        return input;
    }
}
