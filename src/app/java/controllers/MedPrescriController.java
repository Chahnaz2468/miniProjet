package controllers;
import entities.MedPrescri;
import entities.MedRadio;
import services.MedPrescriServices;
import ihm.MedPrescriIHM;
import java.util.List;
import java.util.Scanner;

public class MedPrescriController {
    private MedPrescriServices mps;

    public MedPrescriController(MedPrescriServices mps) {
        this.mps = mps;
    }

    public MedPrescriServices getMps() {
        return mps;
    }

    public void setMps(MedPrescriServices mps) {
        this.mps = mps;
    }

    public void showMedPrescriMenu() {
        Scanner scanner = new Scanner(System.in);
        MedPrescriIHM ihm = new MedPrescriIHM(this);
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
                    ihm.saisir();
                    break;
                case 2:
                    ihm.modifierTelphoneMedPrescri();
                    break;
                case 3:
                    ihm.supprimerMedPrescri();
                    break;
                case 4:
                    ihm.findmedPrescriById();
                    break;
                case 5:
                    ihm.afficherMedPrescris();
                    break;
                case 6:
                    System.out.println("Retour au menu principal...");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choice != 5);
    }

    public int init(MedPrescri medPrescri) {
        return mps.ajouterMedPrescri(medPrescri);
    }

    public int modif(int id,double num) {
        return mps.modifierTelephoneMedPrescri(id,num);
    }

    public int supp(int id){
        return mps.supprimerMedPrescri(id);
    }

    public List<MedPrescri> affich(){
        return mps.afficherMedprescris();
    }

    public MedPrescri find(int id) {
        return mps.findMedPrescriById(id);
    }
}
