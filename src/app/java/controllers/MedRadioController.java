package controllers;
import entities.MedRadio;
import ihm.MedRadioIHM;
import services.MedRadioServices;
import java.util.List;
import java.util.Scanner;

public class MedRadioController {
    private MedRadioServices mrs;

    public MedRadioController(MedRadioServices mrs) {
        this.mrs = mrs;
    }

    public MedRadioServices getMrs() {
        return mrs;
    }

    public void setMrs(MedRadioServices mrs) {
        this.mrs = mrs;
    }

    public void showMedRadioMenu() {
        Scanner scanner = new Scanner(System.in);
        MedRadioIHM ihm = new MedRadioIHM(this);
        int choice = 0;
        do {
            System.out.println("\n===== Menu Gestion des medecins radiologues =====");
            System.out.println("1. Ajouter un medecin radiologue");
            System.out.println("2. Modifier un medecin radiologue");
            System.out.println("3. Retirer un medecin radiologue");
            System.out.println("4. Trouver un medecin radiologue");
            System.out.println("5. Afficher les medecins radiologues");
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
                    ihm.modifierHorraireMedRadio();
                    break;
                case 3:
                    ihm.supprimerMedRadio();
                    break;
                case 4:
                    ihm.findMedRadioById();
                    break;
                case 5:
                    ihm.afficherMedRadio();
                    break;
                case 6:
                    System.out.println("Retour au menu principal...");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choice != 6);
    }

    public int init(MedRadio medRadio) {
        return mrs.ajouterMedRadio(medRadio);
    }

    public int modif(int id,int hr) {
        return mrs.modifierMedRadio(id,hr);
    }

    public int supp(int id) {
        return mrs.supprimerMedRadio(id);
    }

    public List<MedRadio> affich(){
        return mrs.afficherMedRadios();
    }

    public MedRadio find(int id) {
        return mrs.findMedRadioById(id);
    }
}
