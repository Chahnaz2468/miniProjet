package ihm;

import controllers.ControllerPrincipal;
import controllers.PatientController;
import entities.Patient;


import exceptions.PatientRedondanceException;

import java.util.Scanner;

public class PatientIhm {
    PatientController patientController;

    public PatientIhm() {}

    public PatientIhm(PatientController patientController) {

        this.patientController = patientController;
    }

    public void showPatientMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== Menu Gestion des patients =====");
            System.out.println("1. Afficher les patientq");
            System.out.println("2. Afficher un patient");
            System.out.println("3. modifier un patient");
            System.out.println("4. retirer un atient");
            System.out.println("5. Retour au Menu Principal");
            System.out.print("Choisissez une option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Patient[] patients = patientController.afficherPatients();
                    if (patients != null) {
                        for (Patient p : patients) {

                                System.out.printf("Patient id: %d, nom:%s, prenom:%s, telephone:%f, date de naissance: %s,  adresse: %s",
                                        p.getId(), p.getNom(),p.getPrenom(),p.getTelephone(),p.getDateNaissance(), p.getAddresse());

                        }
                    }
                    break;
                case 2:
                    this.trouverPatient();
                case 3:
                    System.out.println("Entrez l'id de la salle à modifier:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Entrez la nouvel date de naissance");
                    String dateNaissance=scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Entrez la nouvel addresse");
                    String addresse=scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Entrez le nom");
                    String nom=scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Entrez le prénom");
                    String prenom=scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Entrez le nouveau numéro de téléphone ");
                    double telephone = scanner.nextDouble();
                    scanner.nextLine();
                    Patient newPatient = new Patient(id, nom, prenom, telephone, dateNaissance, addresse);
                    patientController.modifiererPatient(id, newPatient);
                    System.out.println("le Patient est modifiée.");
                    break;
                case 4:
                    System.out.println("Entrez l'id de Patient à retirer:");
                    id = scanner.nextInt();
                    patientController.retirerPatient(id);
                    System.out.println("le Patient est retiré.");
                    break;
                case 5:
                    ControllerPrincipal controllerPrincipal = new ControllerPrincipal();
                    controllerPrincipal.init();
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choice !=4);
    }

    public Patient saisirPatient(int id) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println("Entrez le nom du patient:");
        String nom= scanner.nextLine();
        scanner.nextLine();
        System.out.println("Entrez le prénom du patient:");
        String prenom= scanner.nextLine();
        scanner.nextLine();
        System.out.println("Entrez le numéro de téléphone du patient:");
        double telephone = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Entrez le date de naissance du patient:");
        String dateNaissance= scanner.nextLine();
        scanner.nextLine();
        System.out.println("Entrez l'addesse du patient:");
        String addresse= scanner.nextLine();
        scanner.nextLine();

        return new Patient(id, nom, prenom, telephone, dateNaissance, addresse);
    }

    public void trouverPatient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir l'id de patient à trouver:");
        int id = scanner.nextInt();
        if(patientController.trouverPatient(id)==null){
            System.out.println("L'id de patient n'existe pas");
        }else{
            Patient p = patientController.trouverPatient(id);
            System.out.println("nom du patient: "+p.getNom());
            System.out.println("prenom du patient: "+p.getPrenom());
            System.out.println("telephone du patient: "+p.getTelephone());
            System.out.println("date de naissance du patient: "+p.getDateNaissance());
            System.out.println("adresse du patient: "+p.getAddresse());
        }
    }

}
