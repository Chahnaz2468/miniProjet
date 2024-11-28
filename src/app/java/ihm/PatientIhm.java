package ihm;

import controllers.ControllerPrincipal;
import controllers.PatientController;
import entities.Patient;


import exceptions.PatientRedondanceException;

import java.util.Scanner;

public class PatientIhm {
    PatientController patientController;

    public PatientIhm(PatientController patientController) {

        this.patientController = patientController;
    }

    public void showPatientMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== Menu Gestion des patients =====");
            System.out.println("1. Ajouter un Patient");
            System.out.println("2. Afficher les Patients");
            System.out.println("3. modifier les Patients");
            System.out.println("4. retirer les Patients");
            System.out.println("5. Retour au Menu Principal");
            System.out.print("Choisissez une option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Patient patient = saisirPatient();
                    try {
                        patientController.ajouterPatient(patient);
                        System.out.println("Patient ajouté avec succès !");
                    } catch (PatientRedondanceException e) {
                        System.err.println("Erreur : " + e.getMessage());
                    }
                    break;
                case 2:
                    Patient[] patients = patientController.afficherPatients();
                    if (patients != null) {
                        for (Patient p : patients) {

                                System.out.printf("Patient id: %d, nom:%s, prenom:%s, telephone:%f, date de naissance: %s,  adresse: %s",
                                        p.getId(), p.getNom(),p.getPrenom(),p.getTelephone(),p.getDateNaissance(), p.getAddresse());

                        }
                    }
                    break;
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
        } while (choice != 5);
    }

    public Patient saisirPatient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez l'id de patient:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Entrez le nom de patient:");
        String nom= scanner.nextLine();
        scanner.nextLine();
        System.out.println("Entrez le prénom de patient:");
        String prenom= scanner.nextLine();
        scanner.nextLine();
        System.out.println("Entrez le numéro de téléphone de patient:");
        double telephone = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Entrez le date de naissance de patient:");
        String dateNaissance= scanner.nextLine();
        scanner.nextLine();
        System.out.println("Entrez l'addesse de patient:");
        String addresse= scanner.nextLine();
        scanner.nextLine();

        return new Patient(id, nom, prenom, telephone, dateNaissance, addresse);
    }



}
