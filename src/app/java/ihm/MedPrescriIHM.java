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
            System.out.println("1. Modifier un medecin prescripteur");
            System.out.println("2. Retirer un medecin prescripteur");
            System.out.println("3. Trouver un medecin prescripteur");
            System.out.println("4. Afficher les medecins prescripteurs");
            System.out.println("5. Retour au Menu Principal");
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
                    this.modifierTelphoneMedPrescri();
                    break;
                case 2:
                    this.supprimerMedPrescri();
                    break;
                case 3:
                    this.findmedPrescriById();
                    break;
                case 4:
                    this.afficherMedPrescris();
                    break;
                case 5:
                    System.out.println("Retour au menu principal...");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choice != 5);
    }

    public void saisir(int id) {
        Scanner sc = new Scanner(System.in);
        System.out.println("donner le nom: ");
        String nom= sc.next();
        System.out.println("donner le prenom: ");
        String prenom = sc.next();
        System.out.println("donner le numero telephone: ");
        String num = sc.next();
        System.out.println("donner la specialite: ");
        String spe = sc.next();
        MedPrescri medPrescri = new MedPrescri(id, nom, prenom, num, spe);
        if (mpc.ajout(medPrescri) ==1)
            System.out.println("Medecin prescripteur ajouté avec succès ");
        else
            System.out.println("Erreur");
    }

    public void modifierTelphoneMedPrescri(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir l'id du medecin prescripteur: ");
        int id = sc.nextInt();
        System.out.println("Veuillez saisir le nouveau numero telephone: ");
        String telephone = sc.next();
        if (mpc.modif(id,telephone) == 1)
            System.out.println("Médecin prescripteur modifié avec succès.");
        else{
            if (mpc.modif(id,telephone) == 0) {
                System.out.println("Aucun médecin prescripteur trouvé avec cet ID.");
            } else {
                System.out.println("Erreur lors de la modification du médecin prescripteur.");
            }
        }
    }

    public void supprimerMedPrescri(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir l'id du medecin prescripteur à supprimer: ");
        int input = sc.nextInt();
        if (mpc.supp(input) ==1)
            System.out.println("Suppresion faite avec succès ");
        else{
            if(mpc.supp(input) == 0)
                System.out.println("Aucun médecin prescripteur trouvé avec cet ID.");
            else
                System.out.println("Erreur lors de la suppression du médecin prescripteur.");
        }
    }

    public void afficherMedPrescris() {
        List<MedPrescri> medPrescris =mpc.affich();
        if (medPrescris == null || medPrescris.isEmpty()) {
            System.out.println("Aucun médecin prescripteur à afficher.");
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
            System.out.println("Medecin prescripteur:");
            System.out.println("  ID: " + medPrescri.getId());
            System.out.println("  Nom: " + medPrescri.getNom());
            System.out.println("  Prenom: " + medPrescri.getPrenom());
            System.out.println("  Telephone: " + medPrescri.getTelephone());
            System.out.println("  Specialite: " + medPrescri.getSpecialite());
            System.out.println("-----------------------------");
        }
    }
}
