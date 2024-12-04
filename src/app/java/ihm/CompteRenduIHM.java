package ihm;

import ihm.PatientIhm;
import ihm.MedRadioIHM;
import controllers.CompteRenduController;
import entities.CompteRendu;
import entities.Patient;
import entities.MedRadio;
import controllers.ControllerPrincipal;
import exceptions.DoubleCompteRenduException;

import java.util.Scanner;
public class CompteRenduIHM {
    CompteRenduController compteRenduController;

    public CompteRenduIHM(CompteRenduController compteRenduController) {
        this.compteRenduController = compteRenduController;
    }

    public void showCompteRenduMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== Menu Gestion des Comptes Rendus =====");
            System.out.println("1. Ajouter un Compte Rendu(pdf)");
            System.out.println("2. Afficher les Comptes Rendus");
            System.out.println("3. Modifier un Compte Rendu");
            System.out.println("4. Retirer un Compte Rendu");
            System.out.println("5. Retour au Menu Principal");
            System.out.print("Choisissez une option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    CompteRendu compteRendu = saisirCompteRendu();
                    try {
                        compteRenduController.ajouterCompteRendu(compteRendu);
                        System.out.println("Compte rendu ajouté avec succès !");
                    } catch (DoubleCompteRenduException e) {
                        System.err.println("Erreur : " + e.getMessage());
                    }
                    compteRenduController.saveCompteRenduAsPdf(compteRendu);
                    break;
                case 2:
                    CompteRendu[] comptesRendus = compteRenduController.afficherCompteRendus();
                    if (comptesRendus == null || comptesRendus.length == 0) {
                        System.out.println("Aucun compte rendu n'est enregistré.");
                    } else {
                        System.out.println("\n===== Liste des Comptes Rendus =====");
                        for (CompteRendu cr : comptesRendus) {
                            if (cr != null) {
                                System.out.println(cr);
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Entrez l'ID du compte rendu à modifier:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Entrez le nouveau contenu du compte rendu:");
                    String contenu = scanner.nextLine();
                    System.out.println("Entrez les informations du patient :");
                    PatientIhm patientIhm = new PatientIhm();
                    System.out.println("Entrez l'id du patient :");
                    int idp = scanner.nextInt();
                    scanner.nextLine();
                    Patient patient = patientIhm.saisirPatient(idp);
                    System.out.println("Entrez les informations du médecin radiologue :");
                    MedRadioIHM medRadioIHM=new MedRadioIHM();
                    MedRadio medRadio = medRadioIHM.saisir();
                    CompteRendu nouveauCompteRendu = new CompteRendu(id, contenu, patient, medRadio);
                    compteRenduController.modifierCompteRendu(id, nouveauCompteRendu);
                    System.out.println("Compte rendu modifié avec succès.");
                    break;
                case 4:
                    System.out.println("Entrez l'ID du compte rendu à retirer:");
                    id = scanner.nextInt();
                    compteRenduController.retirerCompteRendu(id);
                    System.out.println("Compte rendu retiré avec succès.");
                    break;
                case 5:
                    ControllerPrincipal controllerPrincipal = new ControllerPrincipal();
                    controllerPrincipal.init();
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choice != 5);
    }

    public CompteRendu saisirCompteRendu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez l'ID du compte rendu:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Entrez le contenu du compte rendu:");
        String contenu = scanner.nextLine();

        System.out.println("Entrez les informations du patient :");
        System.out.println("Entrez l'id du patient :");
        int idp = scanner.nextInt();
        scanner.nextLine();
        PatientIhm patientIhm = new PatientIhm();
        Patient patient = patientIhm.saisirPatient(idp);

        System.out.println("Entrez les informations du médecin radiologue :");
        MedRadioIHM medRadioIHM=new MedRadioIHM();
        MedRadio medRadio = medRadioIHM.saisir();

        return new CompteRendu(id, contenu, patient, medRadio);
    }
    public void sauvegarderCompteRenduEnPdf() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir l'ID du compte rendu à sauvegarder en PDF :");
        int id = scanner.nextInt();
        scanner.nextLine();

        CompteRendu compteRendu = null;


        for (CompteRendu cr : compteRenduController.afficherCompteRendus()) {
            if (cr != null && cr.getId() == id) {
                compteRendu = cr;
                break;
            }
        }

        if (compteRendu == null) {
            System.out.println("Compte rendu introuvable !");
            return;
        }

        boolean success = compteRenduController.saveCompteRenduAsPdf(compteRendu);
        if (success) {
            System.out.println("Le compte rendu a été sauvegardé sous forme de PDF avec succès !");
        } else {
            System.out.println("Erreur lors de la sauvegarde du compte rendu en PDF.");
        }
    }
}
