package ihm;
import controllers.MedPrescriController;
import entities.MedPrescri;

import java.util.List;
import java.util.Scanner;

public class MedPrescriIHM {
    private MedPrescriController mpc;

    public MedPrescriIHM(MedPrescriController mpc) {
        this.mpc = mpc;
    }

    public MedPrescriController getMpc() {
        return mpc;
    }

    public void setMpc(MedPrescriController mpc) {
        this.mpc = mpc;
    }

    public void showMedPrescriMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("\n===== Menu Gestion des medecins prescripteurs =====");
            System.out.println("1. Ajouter un medecin prescripteur");
            System.out.println("2. Modifier un medecin prescripteur");
            System.out.println("3. Retirer un medecin prescripteur");
            System.out.println("4. Trouver un medecin prescripteur");
            System.out.println("5. Afficher les medecins prescripteurs");
            System.out.println("6. Retour au Menu Principal");
            System.out.print("Choisissez une option: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Entrée invalide. Veuillez entrer un entier.");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1:
                    this.saisir();
                    break;
                case 2:
                    this.modifierTelphoneMedPrescri();
                    break;
                case 3:
                    this.supprimerMedPrescri();
                    break;
                case 4:
                    this.findmedPrescriById();
                    break;
                case 5:
                    this.afficherMedPrescris();
                    break;
                case 6:
                    System.out.println("Retour au menu principal...");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choice != 6);
    }

    public void saisir() {
        Scanner sc = new Scanner(System.in);
        System.out.println("donner l'identifiant: ");
        int id = sc.nextInt();
        System.out.println("donner le nom: ");
        String nom= sc.next();
        System.out.println("donner le prenom: ");
        String prenom = sc.next();
        System.out.println("donner le numero telephone: ");
        double num = sc.nextDouble();
        System.out.println("donner la specialite: ");
        String spe = sc.next();
        MedPrescri medPrescri = new MedPrescri(id, nom, prenom, num, spe);
        if (mpc.ajout(medPrescri) ==1)
            System.out.println("Medecin prescripteur ajouté avec succes ");
        else
            System.out.println("Erreur");
    }

    public void modifierTelphoneMedPrescri(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir l'id de medecin prescripteur: ");
        int id = sc.nextInt();
        System.out.println("Veuillez saisir le nouveau numero telephone: ");
        double telephone = sc.nextDouble();
        if (mpc.modif(id,telephone) == 1)
            System.out.println("Modification faite avec succes ");
        else
            System.out.println("Erreur");
    }

    public void supprimerMedPrescri(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir l'id de medecin prescripteur à supprimer: ");
        int input = sc.nextInt();
        if (mpc.supp(input) ==1)
            System.out.println("Suppresion faite avec succes ");
        else
            System.out.println("Erreur");
    }

    public void afficherMedPrescris() {
        List<MedPrescri> medPrescris =mpc.affich();
        if (medPrescris == null || medPrescris.isEmpty()) {
            System.out.println("Aucun examen à afficher.");
            return;
        }

        for (MedPrescri medPrescri : medPrescris) {
            System.out.println("Medecin prescripteur:");
            System.out.println("  ID: " + medPrescri.getId());
            System.out.println("  Nom: " + medPrescri.getNom());
            System.out.println("  Prenom: " + medPrescri.getPrenom());
            System.out.println("  Telephone: " + medPrescri.getTelephone());
            System.out.println("  Specialite: " + medPrescri.getSpecialite());
            System.out.println("-----------------------------");
        }
    }

    public void findmedPrescriById() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir l'id du medecin prescripteur à trouver: ");
        int id = sc.nextInt();
        MedPrescri medPrescri;
        if (mpc.find(id) == null)
            System.out.println("Erreur");
        else {
            medPrescri = mpc.find(id);
            System.out.println("Medecin radiologue:");
            System.out.println("  ID: " + medPrescri.getId());
            System.out.println("  Nom: " + medPrescri.getNom());
            System.out.println("  Prenom: " + medPrescri.getPrenom());
            System.out.println("  Telephone: " + medPrescri.getTelephone());
            System.out.println("  Specialite: " + medPrescri.getSpecialite());
            System.out.println("-----------------------------");
        }
    }
}
